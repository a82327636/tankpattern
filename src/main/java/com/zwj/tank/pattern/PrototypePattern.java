package com.zwj.tank.pattern;

/**
 * @ProjectName: tankpattern
 * @Package: com.zwj.tank.pattern
 * @ClassName: PrototypePattern
 * @Author: zwj
 * @Description: 注释 原型模式 (建议少使用)
 *
 * 原型模式：用原型实例指定创建对象的种类，并且通过拷贝这些原型创建新的对象。
 *
 * @Date: 2020/11/25 15:02
 * @Version: 1.0
 */
class PrototypePattern {
    public static void main(String[] args)
    {
        ProtoType pt1 = new ProtoType();
        pt1.setName("protoType_1");
        ProtoType pt2 = pt1.clone();
        System.out.println(pt1 == pt2);
        System.out.println(pt1.getClass() == pt2.getClass());
        pt2.setName("protoType_2");
        System.out.println(pt1.getName()+" "+pt2.getName());
    }
}


class ProtoType implements Cloneable
{
    private String name;

    @Override
    public ProtoType clone()
    {
        try
        {
            return (ProtoType)super.clone();
        }
        catch (CloneNotSupportedException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}