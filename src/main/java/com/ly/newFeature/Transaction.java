package com.ly.newFeature;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: liyan
 * @Description:
 * @Date: Created in 10:38 2018/9/18
 * @Modified By:
 */
public class Transaction {
    private final int id;
    private final Integer value;
    private final Type type;

    private Transaction(int id, Integer value, Type type) {
        this.id = id;
        this.value = value;
        this.type = type;
    }

    public enum Type{
        A,B,C,D, GROCERY
    }

    public int getId() {
        return id;
    }

    public Integer getValue() {
        return value;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return "[ id = " + id + ";" + " value = " + value + ";"+ " type = " + type + " ]";
    }

    public static void main(String[] args){

        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction(1, 10, Type.GROCERY));
        transactions.add(new Transaction(3, 30, Type.GROCERY));
        transactions.add(new Transaction(6, 60, Type.GROCERY));
        transactions.add(new Transaction(5, 50, Type.GROCERY));
        transactions.add(new Transaction(2, 20, Type.A));
        transactions.add(new Transaction(4, 40, Type.C));

        /*
        JDK7实现排序
         */

        // 发现type为GEOCERY的所有交易
        List<Transaction> groceryTransactions = new ArrayList<>();
        for (Transaction t : transactions) {
            if (t.getType() == Type.GROCERY) {
                System.out.println(t.toString());
                groceryTransactions.add(t);
            }
        }

        // 集合排序，交易做降序排序
        Collections.sort(groceryTransactions, new Comparator<Transaction>() {
            @Override
            public int compare(Transaction o1, Transaction o2) {
                return o2.getValue().compareTo(o1.getValue());
//                return o1.getValue() - o2.getValue(); // 交易做升序排序
            }
        });

        // 获取降序排序后的交易id
        for (Transaction transaction : groceryTransactions) {
            System.out.println(transaction.getId());
        }

        /*
        JDK8实现排序
         */
        transactions.parallelStream()
                .filter(type -> type.getType() == Type.GROCERY)
//                .sorted(Comparator.comparing(Transaction::getValue)) // 升序
                .sorted((a, b) -> a.getValue() - b.getValue())
//                .sorted(Comparator.comparing(Transaction::getValue).reversed()) // 降序
//                .sorted((a, b) -> b.getValue() - a.getValue())
//                .map(Transaction::getId)
                .map(i -> i.getId())
                .collect(Collectors.toList())
                .forEach(id -> System.out.println("id = " + id));




    }
}
