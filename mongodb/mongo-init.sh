chmod 600 /usr/local/bin/mongodb/mongo-cluster.key
mongod --replSet mongo-cluster --keyFile /usr/local/bin/mongodb/mongo-cluster.key --dbpath /data/db --bind_ip_all
