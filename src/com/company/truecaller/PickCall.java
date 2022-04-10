package com.company.truecaller;

public class PickCall implements Observer {
    private final Call call;
    private User dialler;
    private final User callee;
    private boolean isSpam;
    private boolean isRinging;

    public PickCall(User callee, Call call) {
        this.call = call;
        this.call.register(this);
        this.callee = callee;
    }

    @Override
    public void update() {
        this.dialler = call.getDialler();
        isSpam = dialler.getSpamCount() > 0;
        System.out.println("Dialler is: "+dialler.getName());
        isRinging = !callee.isDiallerBlocked(dialler.getMobile());
    }

    public User getDialler() {
        return dialler;
    }

    public boolean isSpam() {
        return isSpam;
    }

    public boolean isRinging() {
        return isRinging;
    }
}
