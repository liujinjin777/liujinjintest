package com.liujinjin.temp.hash;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.*;

/** 
  * 带虚拟节点的一致性Hash算法 
  */  
 public class ConsistentHashingWithoutVirtualNode {  
  
     //待添加入Hash环的服务器列表  
     private static String[] servers = {"a", "b", "c", "d", "e", "f"};
       
     //真实结点列表,考虑到服务器上线、下线的场景，即添加、删除的场景会比较频繁，这里使用LinkedList会更好  
     private static List<String> realNodes = new LinkedList<String>();  
       
     //虚拟节点，key表示虚拟节点的hash值，value表示虚拟节点的名称  
     private static SortedMap<Long, String> virtualNodes = new TreeMap<>();
               
     //虚拟节点的数目，这里写死，为了演示需要，一个真实结点对应5个虚拟节点  
     private static final int VIRTUAL_NODES = 3;
       
     static{  
         //先把原始的服务器添加到真实结点列表中  
         realNodes.addAll(Arrays.asList(servers));
           
         //再添加虚拟节点，遍历LinkedList使用foreach循环效率会比较高  
         for (String str : realNodes){  
             for(int i=0; i<VIRTUAL_NODES; i++){  
                 String virtualNodeName =  str + "-" + String.valueOf(i) ;
                 Long hash = getHash(virtualNodeName);
                 //System.out.println("虚拟节点[" + virtualNodeName + "]被添加, hash值为" + hash);
                 virtualNodes.put(hash, virtualNodeName);  
             }  
         }  
     }
       
     //使用FNV1_32_HASH算法计算服务器的Hash值,这里不使用重写hashCode的方法，最终效果没区别  
     private static long getHash(String str){
         final int p = 16777619;  
         int hash = (int)2166136261L;  
         for (int i = 0; i < str.length(); i++)  
             hash = (hash ^ str.charAt(i)) * p;  
         hash += hash << 13;  
         hash ^= hash >> 7;  
         hash += hash << 3;  
         hash ^= hash >> 17;  
         hash += hash << 5;  
           
         // 如果算出来的值为负数则取其绝对值  
         if (hash < 0)  
             hash = Math.abs(hash);  
         return hash;  
     }

    private static Long hash(String key) {

        ByteBuffer buf = ByteBuffer.wrap(key.getBytes());
        int seed = 0x1234ABCD;

        ByteOrder byteOrder = buf.order();
        buf.order(ByteOrder.LITTLE_ENDIAN);

        long m = 0xc6a4a7935bd1e995L;
        int r = 47;

        long h = seed ^ (buf.remaining() * m);

        long k;
        while (buf.remaining() >= 8) {
            k = buf.getLong();

            k *= m;
            k ^= k >>> r;
            k *= m;

            h ^= k;
            h *= m;
        }

        if (buf.remaining() > 0) {
            ByteBuffer finish = ByteBuffer.allocate(8).order(
                    ByteOrder.LITTLE_ENDIAN);
            // for big-endian version, do this first:
            // finish.position(8-buf.remaining());
            finish.put(buf).rewind();
            h ^= finish.getLong();
            h *= m;
        }

        h ^= h >>> r;
        h *= m;
        h ^= h >>> r;

        buf.order(byteOrder);
        return h;
    }
       
     //得到应当路由到的结点  
     private static String getServer(String key){  
        //得到该key的hash值  
         Long hash = hash(key);
         // 得到大于该Hash值的所有Map  
         SortedMap<Long, String> subMap = virtualNodes.tailMap(hash);
         String virtualNode;  
         if(subMap.isEmpty()){  
            //如果没有比该key的hash值大的，则从第一个node开始  
            Long i = virtualNodes.firstKey();
            //返回对应的服务器  
            virtualNode = virtualNodes.get(i);  
         }else{  
            //第一个Key就是顺时针过去离node最近的那个结点  
            Long i = subMap.firstKey();
            //返回对应的服务器  
            virtualNode = subMap.get(i);  
         }  
         //virtualNode虚拟节点名称要截取一下  
         if(StringUtils.isNotBlank(virtualNode)){
             return virtualNode.substring(0, virtualNode.indexOf("-"));
         }  
         return null;  
     }  
       
     public static void main(String[] args) throws ClassNotFoundException {
         /*String[] keys = {"太阳", "月亮", "星星"};
         for (String key : keys)
             System.out.println("[" + key + "]的hash值为" +
                     getHash(key) + ", 被路由到结点[" + getServer(key) + "]");*/

         Class.forName("com.liujinjin.temp.hash.ConsistentHashingWithoutVirtualNode");
         System.out.println("--------------------------");
         System.out.println(JSON.toJSONString(virtualNodes));
     }  
 }  