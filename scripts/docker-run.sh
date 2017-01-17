#!/bin/bash
docker run --rm -e "PUBLISH_IP=127.0.0.1" -p 9200:9200 -p 9300:9300 -v $(pwd)/config:/usr/share/elasticsearch/config --name elastic elasticsearch:latest
