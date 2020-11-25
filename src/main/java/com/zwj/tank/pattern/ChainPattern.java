package com.zwj.tank.pattern;

import java.math.BigDecimal;

/**
 * @ProjectName: tankpattern
 * @Package: com.zwj.tank.pattern
 * @ClassName: ChainPattern
 * @Author: zwj
 * @Description: 注释 责任链模式
 *
 * 使多个对象都有机会处理请求，从而避免请求的发送者和接受者之间的耦合关系。
 * 将这些对象连成一条链，并沿着这条链传递该请求，知道有一个对象处理它为止
 * @Date: 2020/11/25 17:42
 * @Version: 1.0
 */
public class ChainPattern {

    public static void main(String[] args) {
        ConsumeHandler project = new ProjectHandler();
        ConsumeHandler dept = new DeptHandler();
        ConsumeHandler general = new GeneralHandler();
        project.setNextHandler(dept);
        dept.setNextHandler(general);
        project.doHandler("jj", new BigDecimal(2000));
        project.doHandler("jj", new BigDecimal(300));
        project.doHandler("qq", new BigDecimal(2000));
        project.doHandler("zzh", new BigDecimal(20000));
        project.doHandler("qq", new BigDecimal(20000));

    }
}


// 抽象处理角色ConsumeHandler
abstract class ConsumeHandler
{
    private ConsumeHandler nextHandler;

    public ConsumeHandler getNextHandler()
    {
        return nextHandler;
    }

    public void setNextHandler(ConsumeHandler nextHandler)
    {
        this.nextHandler = nextHandler;
    }

    public abstract void doHandler(String user, BigDecimal free);
}

//具体处理角色
class ProjectHandler extends ConsumeHandler
{
    @Override
    public void doHandler(String user, BigDecimal free)
    {
        if(free.doubleValue() < 1000)
        {
            if(user.equals("jj"))
                System.out.println(user+"报销不通过");
            else
                System.out.println(user+"给予报销："+free);
        }
        else
        {
            if(getNextHandler() != null)
            {
                getNextHandler().doHandler(user, free);
            }
        }
    }
}

class DeptHandler extends ConsumeHandler
{
    @Override
    public void doHandler(String user, BigDecimal free)
    {
        if(free.doubleValue() < 5000)
        {
            if(user.equals("qq"))
                System.out.println(user+"报销不通过");
            else
                System.out.println(user+"给予报销："+free);
        }
        else
        {
            if(getNextHandler() != null)
            {
                getNextHandler().doHandler(user, free);
            }
        }
    }
}

class GeneralHandler extends ConsumeHandler
{
    @Override
    public void doHandler(String user, BigDecimal free)
    {
        if(free.doubleValue() >= 5000)
        {
            if(user.equals("zzh"))
                System.out.println(user+"报销不通过");
            else
                System.out.println(user+"给予报销："+free);
        }
        else
        {
            if(getNextHandler() != null)
            {
                getNextHandler().doHandler(user, free);
            }
        }
    }
}


/**
 * 责任链模式的缺点：当责任链的链结构比较长比较复杂的话，会产生很多内存垃圾对象，
 *  他们在实际处理中，并没有发挥任何的作用。
 *
 * JDK中的责任链模式
 * java.util.logging.Logger#log()
 * javax.servlet.Filter#doFilter()
 * */
