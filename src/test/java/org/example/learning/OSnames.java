package org.example.learning;

import java.util.*;

public class OSnames {
    public static void main(String args[]){
        System.out.println(System.getProperty("os.name"));
        System.out.println(System.getProperty("os.version"));
        System.out.println("");
        HashMap<Integer, Integer> map= new HashMap<Integer, Integer>();
        map.put(1,100);
        map.put(2,99);
        map.put(3,101);
        map.put(4,98);

        List<HashMap.Entry<Integer, Integer>> list = new LinkedList<Map.Entry<Integer, Integer>>(map.entrySet());

        System.out.println("Before sorting"+list);

//        Collections.reverse(list);
//        System.out.println("Reverse Collections: "+list );
        Collections.sort(list, new Comparator<HashMap.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return (o1.getValue().compareTo(o2.getValue()) );
            }
        });

        System.out.println("After Sorting: "+list);
//        for (int i = 0; i <list.size() ; i++) {
//            System.out.println(list.get(i));
//
//        }

        HashMap<Integer, Integer> hashMap = new LinkedHashMap<Integer, Integer>();
        for (Map.Entry<Integer, Integer> aa : list){
            hashMap.put(aa.getKey(), aa.getValue());
        }
        System.out.println("added back to hash:" +hashMap);

        int key=2;
        for (int i = hashMap.size(); i > hashMap.size(); i--) {
            System.out.println(hashMap.get(i).intValue());

        }
        for (Map.Entry<Integer, Integer> aa : hashMap.entrySet()){
//            hashMap.put(aa.getKey(), aa.getValue());

        }
    }
}
