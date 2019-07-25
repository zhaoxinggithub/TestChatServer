package com.treeTestDemo;


import java.util.Arrays;

public class JavaAPIDemo {
    public static void main(String[] argas){
    BinaryTree<Persion> tree=new BinaryTree<Persion>();
    tree.add(new Persion("小强-80",80));
        tree.add(new Persion("小强-30",30));//
        tree.add(new Persion("小强-90",90));//
        tree.add(new Persion("小强-50",50));//
        tree.add(new Persion("小强-60",60));//
        tree.add(new Persion("小强-95",95));
        tree.add(new Persion("小强-85",85));
        tree.add(new Persion("小强-70",70));
        tree.add(new Persion("小强-55",55));
        tree.add(new Persion("小强-10",10));
        tree.remove(new Persion("小强-10",10));
     System.out.println(Arrays.toString(tree.toArray()));
    }
}

class BinaryTree <T extends Comparable<T>>{
    private class Node {
        private Comparable<T> data;
        private Node parent;
        private Node left;
        private Node right;

        public Node(Comparable<T> data) {
            this.data = data;
        }

        /*
        * 实现节点数据的适当位置的存储
        * */
        public void addNode(Node newNode){
            if(newNode.data.compareTo((T)this.data)<=0){//比当前节点数据小
                if(this.left==null){//没有左左子数
                    this.left=newNode;//保存左子数
                    newNode.parent=this;//保存父节点
                }else{
                    this.left.addNode(newNode);//继续向下判断
                }
            }else{//比根节点的数据要大
                if(this.right==null){//没有右子数
                    this.right=newNode;
                    newNode.parent=this;
                }else{
                    this.right.addNode(newNode);//继续向上判断
                }

            }
        }

        /**
         * 实现所以数据的获取处理，按照中序遍历的形式来完成
         */
        public void toArrayNode(){
            if(this.left!=null){//有左子数
                this.left.toArrayNode();;//递归调用
            }
            BinaryTree.this.returnData[BinaryTree.this.foot++]=this.data;
            if(this.right!=null){
                this.right.toArrayNode();//有右子数
            }
        }

        /**
         * 找到返回true,找不到返回false
         */
        public boolean containsNode(Comparable<T> data){
            if(data.compareTo((T)this.data)==0){
                return true;//找到了
            } else if (data.compareTo((T) this.data) < 0) {//左边有数据
                if(this.left!=null){
                    return this.left.containsNode(data);
                }else{
                    return false;
                }
            }else{
                if(this.right!=null){
                    return this.right.containsNode(data);
                }else{
                    return false;
                }
            }
        }

        /**
         * 获取要删除的节点对象
         */
        public Node getRemoveNode(Comparable<T> data){
            if(data.compareTo((T)this.data)==0){
                return this;//找到了
            } else if (data.compareTo((T) this.data) < 0) {//左边有数据
                if(this.left!=null){
                    return this.left.getRemoveNode(data);
                }else{
                    return null;
                }
            }else{
                if(this.right!=null){
                    return this.right.getRemoveNode(data);
                }else{
                    return null;
                }
            }
        }


    }

    /**
     * 以下为二叉树的功能
     */
    private Node root;//保存的是根节点
    private int count;//保存数据个数
    private Object[] returnData;//返回的数据
    private int foot=0;//角标控制
    /**
     * 进行数据的保存
     * @param data
     */
    public void add(Comparable<T> data){
        if(data==null){
            throw new NullPointerException("保存数据不容许为空！");
        }
        //所以的数据本身不具备有节点关系的匹配，那么一定要将其包装在Node类之中
        Node newNode=new Node(data);//保存节点
        if(this.root==null){//现在没有根节点，则第一个节点作为根节点
            this.root=newNode;
        }else{
            this.root.addNode(newNode);//交由Node负责处理
        }
        this.count++;
    }

    /***
     * 以对象数组返回全部数据，如果没有就返回为null
     */
    public Object [] toArray(){
        if(this.count==0){
            return null;
        }
        this.returnData=new Object[this.count];//保存长度为睡觉觉长度
        this.foot=0;//角标清零
        this.root.toArrayNode();//直接通过Node类负责
        return this.returnData;//返回全部的数据
    }

    /**
     * 删除操作
     */
    public void remove(Comparable<T> data){
        if(this.root==null){//根节点不存在
            return;//结束调用
        }else{
            if(this.root.data.compareTo((T)data)==0){// 要删除的是根节点
                Node movenode=this.root.right;
                while(movenode.left!=null){
                    movenode=movenode.left;//一直向左找
                }
                movenode.left=this.root.left;
                movenode.right=this.root.right;
                movenode.parent.left=null;
                this.root=movenode;
            }else{
                Node removeNode=this.root.getRemoveNode(data);//找到要删除的节点
                if(removeNode!=null){
                    //情况一 没有任何子节点
                    if (removeNode.left == null||removeNode.right==null) {
                        removeNode.parent=null;
                    }else if(removeNode.left!=null||removeNode.right==null){//左面不为空
                        removeNode.parent.left=removeNode.left ;
                        removeNode.left.parent=removeNode.parent;
                    }else if(removeNode.right!=null||removeNode.left==null){
                        removeNode.parent.left=removeNode.right;
                        removeNode.right.parent=removeNode.parent;
                    }else{//两边都要节点，则将右边节点中最左面的节点找到
                        Node moveNode=removeNode.right;//移动节点
                        while(moveNode.left!=null){//现在还有左面节点
                            moveNode=moveNode.left;
                        }
                        removeNode.parent.left=moveNode;
                        moveNode.parent.left=null;//断开链接
                        moveNode.parent=removeNode.parent;
                        moveNode.right=removeNode.right;
                        moveNode.left=removeNode.left;

                    }

                }
            }
            this.count--;
        }

    }
}

class Persion implements Comparable<Persion>{
    private String name;
    private int age;
    public Persion(String name,int age){
        this.name=name;
        this.age=age;
    }

    @Override
    public int compareTo(Persion o) {

        return this.age-o.age;
    }

    @Override
    public String toString() {
        return "Persion{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}'+'\n';
    }
}