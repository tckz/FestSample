package com.example;

import org.fest.swing.annotation.GUITest;
import org.fest.swing.edt.FailOnThreadViolationRepaintManager;
import org.fest.swing.edt.GuiActionRunner;
import org.fest.swing.edt.GuiQuery;
import org.fest.swing.fixture.FrameFixture;
import org.fest.swing.junit.v4_5.runner.GUITestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

@GUITest
@RunWith(GUITestRunner.class)
public class GUIChanTest1 {

	FrameFixture fixture;

	@BeforeClass
	public static void setUpOnce() {
		FailOnThreadViolationRepaintManager.install();
	}

	@Before
	public void setUp() throws Exception {

		GUIChan frame = GuiActionRunner.execute(new GuiQuery<GUIChan>() {
			protected GUIChan executeInEDT() {
					GUIChan f = new GUIChan(new String[]{});
					f.setVisible(true);
					return f;  
			}
		});
	
		this.fixture = new FrameFixture(frame);
	}

	@After
	public void tearDown() throws Exception {
		this.fixture.cleanUp();
	}

	@Test
	public void testMain() {
		this.fixture.button("pushbutton").click();
		this.fixture.optionPane().requireMessage("yo");
	}

}
