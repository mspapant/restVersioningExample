**The integration Flow**

![Alt text](http://g.gravizo.com/g?
 digraph g{
   rankdir=LR;
   "FILE" -> "FileParseActivator" -> "StringToProductTransformer" -> "ProductNormalizerTransformer" -> "PersistProductFilter" -> "AggregatorActivator" -> "PersistProductActivator"
 }
)
