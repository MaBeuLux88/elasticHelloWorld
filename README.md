# Hello World Java-Elastic
Just a little Elastic client test with Java.

# Avoid Docker error when starting Elastic container: 
Elastic uses a hybrid mmapfs / niofs directory which requires a larger MMAP size than the default one.

To alter temporarily your system run this : `sudo sysctl -w vm.max_map_count=262144`

More details about this [here](https://www.elastic.co/guide/en/elasticsearch/reference/current/vm-max-map-count.html).

# How to check that the insert worked : 

## In sense (google chrome plug-in) you can type this :
```
GET _search
   {
      "query": {
         "match_all": {}
      }
   }
```

## In a console you can type this : 
```
curl -XGET 'localhost:9200/_search?pretty' -d'
{
    "query": {
        "match_all": {}
    }
}
'
```