package edu.kis.powp.jobs2d.transformations.changedriver;

import edu.kis.powp.observer.Subscriber;

public class WrapDriverWithRecordingDecoratorObserverWhileChangingDriver implements Subscriber {
    @Override
    public void update() {
        RecordCommandsForTransformation.wrapDriverWithRecordingDecorator();
    }
}
