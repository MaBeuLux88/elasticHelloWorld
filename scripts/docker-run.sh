#!/bin/bash
docker stop elastic
docker rm -v elastic
docker run -d -p 9200:9200 -p 9300:9300 -v $(pwd)/config:/usr/share/elasticsearch/config --name elastic elasticsearch:latest
