**The integration Flow**

![Alt text](http://webgraphviz.com
 digraph g{
   rankdir=LR;
   "FILE" -> "FileParseActivator" -> "StringToProductTransformer" -> "ProductNormalizerTransformer" -> "PersistProductFilter" -> "AggregatorActivator" -> "PersistProductActivator"
 }
)
