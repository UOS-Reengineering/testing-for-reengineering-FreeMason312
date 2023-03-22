package example.project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import example.project.domain.Scenario;
import example.project.domain.SimulationResult;
import example.project.domain.Snapshot;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestChecker {

    @Test
    public void testCheckCollisionViolations()
    {
        // setup
        //Simulator simulator = new Simulator("dummy");
        Simulator simulator = mock();
        SimulationResult sr = new SimulationResult();
        Scenario scenario = new Scenario();
        Snapshot snapshot = new Snapshot();
        List<Float> car = new ArrayList<>();
        List<Float> ego = new ArrayList<>();
        car.add((float) 1.0);
        car.add((float) 1.0);
        snapshot.carInFrontPos = car;
        ego.add((float) 0.5);
        ego.add((float) 0.5);
        snapshot.egoCarPos = ego;
        sr.snapshots.add(snapshot);
        when(simulator.run(scenario)).thenReturn(sr);

        // testing target
        Checker checker = new Checker(simulator);
        boolean isCollision = checker.checkCollisionViolations(scenario); // this invokes a null pointer exception due to the dummy simulator
        assertEquals(false, isCollision);
    }

}