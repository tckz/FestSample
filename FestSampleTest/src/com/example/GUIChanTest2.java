package com.example;

import java.awt.Frame;

import org.fest.swing.annotation.GUITest;
import org.fest.swing.core.BasicRobot;
import org.fest.swing.core.GenericTypeMatcher;
import org.fest.swing.core.Robot;
import org.fest.swing.edt.FailOnThreadViolationRepaintManager;
import org.fest.swing.finder.WindowFinder;
import org.fest.swing.fixture.FrameFixture;
import org.fest.swing.junit.v4_5.runner.GUITestRunner;
import org.fest.swing.launcher.ApplicationLauncher;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

@GUITest
@RunWith(GUITestRunner.class)
public class GUIChanTest2 {

	FrameFixture fixture;
	Robot robot;
	
	@BeforeClass
	public static void setUpOnce() {
		FailOnThreadViolationRepaintManager.install();
	}

	@Before
	public void setUp() throws Exception {

		ApplicationLauncher.application(GUIChan.class).withArgs("Ya").start();
		robot = BasicRobot.robotWithCurrentAwtHierarchy();

		GenericTypeMatcher<Frame> matcher = new GenericTypeMatcher<Frame>(Frame.class) {
			  protected boolean isMatching(Frame frame) {
				  String title = frame.getTitle();
				  return "GUIChan".equals(title) && frame.isShowing();
			  }
		};

		this.fixture = WindowFinder.findFrame(matcher).using(robot);

	}

	@After
	public void tearDown() throws Exception {
		this.robot.cleanUp();
	}

	@Test
	public void testMain() {
		this.fixture.button("pushbutton").click();
		this.fixture.optionPane().requireMessage("Ya");
	}

}
