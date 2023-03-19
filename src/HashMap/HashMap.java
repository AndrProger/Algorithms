package HashMap;

public class HashMap<K extends Object, V extends Object> {
    private int basketCount =16;//default
    private  int basketCountBusy=0;
    private HashMapNode<K, V>[] baskets=new HashMapNode[basketCount];
    private float loadFactor=0.7f;

    public V add(K key,V value){
        HashMapNode node=new HashMapNode<K,V>(key,value);
        CheckLoad();
        return  addWithOutCheck(node,this.baskets);
    }

    private void CheckLoad() {
        float predict=(float)basketCountBusy/basketCount;
        if(predict>=loadFactor){
            basketCountBusy=0;
            basketCount*=2;
            HashMapNode<K, V>[] basketsNew=new HashMapNode[basketCount];
            for(int i=0;i<baskets.length;i++){
                HashMapNode node =baskets[i];
                while (node!=null){
                    addWithOutCheck(node,basketsNew);
                    node = node.getNextNode();
                }
            }
            baskets=basketsNew;

        }

    }

    public V addWithOutCheck(HashMapNode node, HashMapNode<K, V>[] baskets){

        int index=getHashCode(node.getKey().hashCode());

        if(baskets[index]!=null){
            HashMapNode nodeCurrent=baskets[index];
            while(true){
                if(node.getKey().equals(nodeCurrent.getKey())){
                    nodeCurrent.setValue(node.getValue());
                    return (V) node.getValue();
                }
                if(nodeCurrent.getNextNode()==null){
                    nodeCurrent.setNextNode(node);
                    return null;
                }
                nodeCurrent=nodeCurrent.getNextNode();
            }
        }
        else {
            basketCountBusy++;
            baskets[index]=node;
        }
        return null;
    }
    public  V get(K key){
        int index=getHashCode(key.hashCode());
        HashMapNode node =baskets[index];
        while (node!=null){
            if (node.getKey().equals(key)){
                return (V) node.getValue();
            }
            node=node.getNextNode();
        }
        return null;
    }
    public void printAllMap(){
        System.out.println("busy:"+basketCountBusy+
                " free:"+(basketCount-basketCountBusy)+
                " loadFactorCurrent:"+((float)basketCountBusy/basketCount));
        for (int i=0;i<basketCount;i++){
            System.out.print("["+i+"]");
            if (baskets[i]==null){
                System.out.print("-> null");
            }else {
                HashMapNode nodeCurrent = baskets[i];
                while (nodeCurrent!=null){
                    System.out.print("-> " +nodeCurrent.toString()+" ");
                    nodeCurrent=nodeCurrent.getNextNode();
                }
            }
            System.out.println();
        }
    }
    private int  getHashCode(int hashCode){
        return Math.abs(hashCode)%basketCount;
    }

}
