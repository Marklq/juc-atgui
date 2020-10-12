package com.dd.juc;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @Package: com.dd.juc
 * @ClassName: AtomicRefer
 * @Author: 东方不败
 * @CreateTime: 2020-10-07 9:42
 * @Description:
 */
@NoArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
class User {

    private String name;
    private String age;

}


public class AtomicRefer {
    public static void main(String[] args) {

        User dd = new User().setAge("22").setName("dd");
        User tt = new User().setAge("20").setName("tt");


        AtomicReference<User> atomicReference = new AtomicReference<>();
        //将原子引用类设置成dd
        atomicReference.set(dd);

        //判断和dd是不是相等的，相等就改为tt
        System.out.println(atomicReference.compareAndSet(dd, tt) + "\t" + atomicReference.get().toString());
        //判断现在的原子引用类型和dd相等否
        System.out.println(atomicReference.compareAndSet(dd, tt) + "\t" + atomicReference.get().toString());


    }

}
