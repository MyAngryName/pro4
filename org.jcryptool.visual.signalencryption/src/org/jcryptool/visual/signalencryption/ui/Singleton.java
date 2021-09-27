package org.jcryptool.visual.signalencryption.ui;

public class Singleton {
    
    private static Singleton instance = null;
    
    private static boolean lockStatus = false;
    
    private static SignalEncryptionDoubleRatchetState.STATE stateValue = null;
    private static int counterChecker = -1;
    
    private Singleton() {
       // Exists only to defeat instantiation.
    }

    public static Singleton getInstance() {
       if(instance == null) {
          instance = new Singleton();
       }
       return instance;
    }
    
    protected static void reset() {
        lockStatus = false;
        stateValue = null;
        counterChecker = -1;
    }
    
    protected static void lock(SignalEncryptionDoubleRatchetState parent, int counter) {
        if(!lockStatus) {
            stateValue = parent.getCurrentState();
            counterChecker = counter;
            lockStatus = true;
            SignalEncryptionViewDoubleRatchet swtParent = parent.getSwtParent();
            parent.setLock();
            System.out.println(counter + " successfully locked!");
        }else {
            System.out.println(counter + " is already locked");
        }
        
    }
    
    protected static void unlock(SignalEncryptionDoubleRatchetState parent, int counter) {
        if (lockStatus) {
            if(counter == counterChecker) {
                reset();
                parent.setUnlock();
                System.out.println(counter + " successfully unlocked!");
            } else {
                System.out.println(counter + " | "+ counterChecker + " cannot be unlocked");
            }
        }else {
            System.out.println(counter + " is already unlocked");
        }
    }
}
