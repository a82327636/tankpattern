package com.zwj.tank.pattern;

/**
 * @ProjectName: tankpattern
 * @Package: com.zwj.tank.pattern
 * @ClassName: CommandPattern
 * @Author: zwj
 * @Description: 注释 命令模式
 *
 * 将一个请求封装为一个对象，从而使你可用不同的请求对客户进行参数化；对请求排队或记录请求日志，以支持可撤销的操作。
 * @Date: 2020/11/25 18:31
 * @Version: 1.0
 */
public class CommandPattern {
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();
        Command playCommand = new PlayCommand(audioPlayer);
        Command rewindCommand = new RewindCommand(audioPlayer);
        Command stopCommand = new StopCommand(audioPlayer);

        Keypad keypad = new Keypad();
        keypad.setPlayCommand(playCommand);
        keypad.setRewindCommand(rewindCommand);
        keypad.setStopCommand(stopCommand);

        keypad.play();
        keypad.rewind();
        keypad.stop();
    }
}


/**
 * 命令模式的角色
 * 1. 客户端角色（Client）：创建一个具体命令（ConcreteCommand）对象并确定其接收者。
 * 2. 命令角色（Command）：声明一个给所有命令类的抽象接口。
 * 3. 具体命令角色(ConcreteCommand)：定义一个接收者和行为之间的弱耦合；实现execute()方法
 * ，负责调用接收者的相应操作。execute()方法叫做执行方法。
 * 4. 请求者角色（Invoker)：负责调用命令对象执行请求，相关的方法叫做行动方法。
 * 5. 接收者角色（Receiver）：负责具体实施和执行一个请求。任何一个类都可以称为接收者，
 * 实施和执行请求的方法叫做行动方法。
 */

// 举个简单例子（录音机有播音Play，倒带Rewind和停止Stop功能）

//
// 接收者角色
class AudioPlayer
{
    public void play()
    {
        System.out.println("Play");
    }

    public void rewind()
    {
        System.out.println("Rewind");
    }

    public void stop()
    {
        System.out.println("Stop");
    }
}

// 抽象命令角色
interface Command
{
    public void execute();
}

// 具体命令角色
class PlayCommand implements Command
{
    private AudioPlayer myAudio;
    public PlayCommand(AudioPlayer audioPlayer)
    {
        this.myAudio = audioPlayer;
    }

    public void execute()
    {
        myAudio.play();
    }
}

class RewindCommand implements Command
{
    private AudioPlayer myAudio;
    public RewindCommand(AudioPlayer audioPlayer)
    {
        this.myAudio = audioPlayer;
    }

    public void execute()
    {
        this.myAudio.rewind();
    }
}

class StopCommand implements Command
{
    private AudioPlayer myAudio;
    public StopCommand(AudioPlayer audioPlayer)
    {
        this.myAudio = audioPlayer;
    }
    public void execute()
    {
        this.myAudio.stop();
    }
}


// 请求这角色（由按键扮演）
class Keypad
{
    private Command playCommand;
    private Command rewindCommand;
    private Command stopCommand;
    public void setPlayCommand(Command playCommand)
    {
        this.playCommand = playCommand;
    }
    public void setRewindCommand(Command rewindCommand)
    {
        this.rewindCommand = rewindCommand;
    }
    public void setStopCommand(Command stopCommand)
    {
        this.stopCommand = stopCommand;
    }
    public void play()
    {
        playCommand.execute();
    }
    public void rewind()
    {
        rewindCommand.execute();
    }
    public void stop()
    {
        stopCommand.execute();
    }
}

