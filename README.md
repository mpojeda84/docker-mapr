This is a simple docker container example that contains:
- A Spring application using Spring Web to expose an HTTP endpoint
- A connection to a MapR-DB table to retrieve a value
- In a docker container that has been created from the MapR official docker images


Pre-requisites:
1. A working MapR cluster (non-secure)
2. A table in that cluster in the path: `/tables/docker-hello-test`
3. A record with _id=1 in that table. To insert, run this in the DB Shell: `insert /tables/docker-hello-test --value '{"_id":"1", "title":"Developers on the Edge"}'`
4. Docker up and running in your computer

To run the demo:

1. Clone this repo
2. Move in the terminal to the project directory 
3. Build the jar by executing `mvn package`
4. Build the docker image from the Dockerfile `docker build -f Dockerfile -t docker-mapr-simple . `
5. Run the image passing CLDB nodes, Cluster name, and other parameters `docker run -it -e MAPR_CLUSTER=maikel.cluster -e MAPR_CLDB_HOSTS=psnode90,psnode91,psnode92 -e MAPR_CONTAINER_USER=mapr -p 8085:8085 docker-mapr-simple`