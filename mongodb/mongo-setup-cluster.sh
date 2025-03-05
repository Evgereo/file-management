echo '>>>>> start mongo'
chmod +x /usr/local/bin/mongodb/mongo-init.sh
/usr/local/bin/mongodb/mongo-init.sh &

echo '>>>>> sleep 5 seconds...'
sleep 5

echo '>>>>> configure replica set'
mongosh --eval '
rs.initiate({
                "_id": "mongo-cluster",
                "version": 1,
                "members": [
                    {
                        "_id": 0,
                        "host": "mongo-node1:27017"
                    },
                    {
                        "_id": 1,
                        "host": "mongo-node2:27017"
                    },
                    {
                        "_id": 2,
                        "host": "mongo-node3:27017"
                    }
                ]
            });
' &&

echo '>>>>> sleep 5 seconds...'
sleep 5

echo '>>>>> create main user'
USER_CREATED=false
while [ "$USER_CREATED" = false ];
do
    mongosh --eval "
        try {
            db.getSiblingDB('admin').createUser ({user: 'root', pwd: 'password', roles:['root']});
            print('User created successfully');
        } catch (e) {
            print(e);
        }
    "

    OUTPUT=$(mongosh -u "root" -p "password" --authenticationDatabase "admin" --eval "print('created')")
    if echo "$OUTPUT" | grep -q "created"; then
        USER_CREATED=true
        echo ">>>>> user 'root' created"
    else
        echo ">>>>> user not created $OUTPUT"
        sleep 5
    fi
done

echo '>>>>> check system status'
mongosh --eval 'rs.status()'

echo '>>>>> initialization complete'
wait
