package Map.jdk8_map;

import java.util.HashMap;
import java.util.Map;

/**
 * demo
 *
 * @author don't ask me
 * @date 2018/9/10 14:38
 */
public class demo_jdk8 {
    public static void main(String[] args) {
        //Map 新特性测试
        Map map = new HashMap();
        for (int i = 0; i < 6; i++) {
            map.put(i,"var"+i);
        }
        map.put(10,null);
        //1.遍历
        map.forEach((key,value)->{
            System.out.println(key+":"+value);
        });
        //2.getOrDefault 带默认值的获取
        System.out.println("-------getOrDefault-------");
        System.out.println(map.getOrDefault(3,"default_value"));
        System.out.println(map.getOrDefault(7,"dafult_value"));
        //3.AbsentValue key存在返回原值，key不存在返回null，并将值置为第二个参数
        System.out.println("-------AbsentValue---------");
        System.out.println(map.putIfAbsent(3,"AbsentValue"));
        System.out.println(map.putIfAbsent(12,"AbsentValue"));
        System.out.println(map.get(12));
        //4.compute 用返回值来覆盖原来的值,返回值为null，则删除该key-value;
        System.out.println("---------compute-----------");
         System.out.println(map.compute(3, (key,value)->key+":"+value+"new"));
         System.out.println(map.compute(4,(key,value)->null));
         map.forEach((k,v)->System.out.println(k+"->"+v));
        //5.computeIfAbsent key匹配，匹配成功返回;匹配不成功则新增一个;匹配成功，但是值为null，则返回新值
        System.out.println("---------computeIfAbsent----------");
        map.put(21,null);
        System.out.println(map.computeIfAbsent(3,key->key+":"+"computeIfAbsent"));
        System.out.println(map.computeIfAbsent(20,key->key+":"+"computeIfAbsent"));
        System.out.println(map.computeIfAbsent(21,key->key+":"+"computeIfAbsent"));
        //6.computeIfPresent key匹配,匹配成功返回;
        System.out.println("----------computeIfPresent----------");
        map.put(21,null);
        System.out.println(map.computeIfPresent(3,(k,v)->k+":"+v+"->computeIfPresent"));
        System.out.println(map.computeIfPresent(25,(k,v)->k+":"+v+"->computeIfPresent"));
        System.out.println(map.computeIfPresent(21,(k,v)->k+":"+v+"->computeIfPresent"));
        System.out.println(map.get(21));
        System.out.println(map.get(25));
        System.out.println(map.computeIfPresent(3,(k,v)->null));
        System.out.println(map.get(21));

        /** 比较
         * compute：根据key做匹配，key,value为参数，匹配到Node做value替换，匹配不到新增node。apply的返回值为null则删除该节点。
         * merge：oldValue，newValue作为为参数，其它功能于compute类似
         * computeIfAbsent：根据key匹配，参数为key,存在且value不为null，不做修改，为null用返回值作为value，不存在则新增
         * computeIfPresent：key,value作为参数，存在,原来的值为null不做操作，否则返回值作为新的value覆盖原来；不存在，不做操作；返回值为null删除该节点
         *
         */

        //7. merge  略....... 一条构建 不解释
        //map.merge(key,defaultValue,(oldValue,newValue)->{ do sth...})

        //8. remove 删除map中元素
        map.remove(5);
        System.out.println(map.get(5));
        map.put(5,"removeEg");
        //remove 两个参数的构建
        map.remove(5,"removepp");
        System.out.println(map.get(5));
        map.remove(5,"removeEg");
        System.out.println(map.get(5));
        //9 replace 替换
        map.put(5,"removeGG");
        map.replace(5,"removepp");
        // replace 替换构建2 key和value同时匹配
        map.replace(5,"removepp","removeGG2");
        System.out.println(map.get(5));
    }
}
