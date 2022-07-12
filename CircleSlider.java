import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.text.*;
import java.util.*;
import java.util.Locale;
import java.util.ResourceBundle;

public class CircleSlider extends JPanel
{
	public final Circle circlePanel;
	public JSlider circleSlider, redSlider, greenSlider, blueSlider;
	public JPanel sliderPanel, textPanel, comboPanel;
	public JTextArea textBox;
	public JComboBox langCombo;
	public Locale locale;
	String[] choice;
	public String lang, loc;

	public CircleSlider()
		{
			// creating panel for circle from Circle class
			circlePanel = new Circle();

			// create sliders
			circleSlider = sliderAttributes(0, 250, 25, 50);
			redSlider = sliderAttributes(0, 255, 0, 50);
			greenSlider = sliderAttributes(0, 255, 0, 50);
			blueSlider = sliderAttributes(0, 255, 0, 50);

			// create panel for sliders
			sliderPanel = new JPanel();
			sliderPanel.setLayout(new GridLayout(4,1,8,8));

			// add panels to program
			add(sliderPanel, BorderLayout.WEST);
			add(circlePanel, BorderLayout.EAST);

			// set colour of sliders to match their respective colour
			redSlider.setBackground(Color.RED);
			greenSlider.setBackground(Color.GREEN);
			blueSlider.setBackground(Color.BLUE);
			circleSlider.setBackground(Color.GRAY);

			// add sliders to panel
			sliderPanel.add(redSlider);
			sliderPanel.add(greenSlider);
			sliderPanel.add(blueSlider);
			sliderPanel.add(circleSlider);

			// create panel for text and language selector
			textPanel = new JPanel();
			textPanel.setPreferredSize(new Dimension(650,300));
			add(textPanel, BorderLayout.SOUTH);

			// create JTextArea for circle properties and figures
			textBox = new JTextArea(3, 10);
			textBox.setPreferredSize(new Dimension(300,275));
			textBox.setEditable(false);
			textPanel.add(textBox, BorderLayout.WEST);
			textPanel.setBorder(BorderFactory.createLineBorder(Color.black));

			// create panel for combobox selector
			comboPanel = new JPanel();
			comboPanel.setPreferredSize(new Dimension(325,300));
			textPanel.add(comboPanel, BorderLayout.EAST);

			// create combobox with choice of languages
			String[] choice = {"English", "French"};
			langCombo = new JComboBox(choice);
			// add Action Listner to take user input
			Action a = new Action();
			langCombo.addActionListener(a);
			langCombo.setSelectedIndex(0);
			comboPanel.add(langCombo);

      	}

	// create attributes for sliders
	public JSlider sliderAttributes (int min, int max, int def, int tickSpace)
	{
			JSlider sliderAtt = new JSlider(JSlider.HORIZONTAL, min, max, def);
			sliderAtt.setMajorTickSpacing(tickSpace); // seperation between ticks
			sliderAtt.setPaintTicks(true); // make ticks visible on slider
			sliderAtt.setPaintLabels(true); // add numeric interpretation to slider
			Change e = new Change(); // create change object
			sliderAtt.addChangeListener(e); // add change listener for user input
			return sliderAtt;
	}

	// user input interpreted
	class Action implements ActionListener
	{
		public void actionPerformed(ActionEvent act)
		{
			if (act.getSource() == langCombo)
			{
				//change text language when selected
				if(langCombo.getSelectedIndex() == 0){
					loc = "en";
					lang = "rb_en";
					locale = new Locale(loc);
		    		ResourceBundle resBun = ResourceBundle.getBundle(lang, locale);

					// set values for circle
					circlePanel.setDiameter(circleSlider.getValue());
					double area = (.25)*(3.14)*(circleSlider.getValue()*circleSlider.getValue());
					double circumference = (3.14)*(circleSlider.getValue());

					// set text
					textBox.setText(resBun.getString("Diameter") + ": " + circleSlider.getValue() +
						"\n" + resBun.getString("Area") + ": " + Math.round(area*100.0)/100.0 + "\n" +
							resBun.getString("Circumference") + ": " + Math.round(circumference*100.0)/100.0);
					}

				if(langCombo.getSelectedIndex() == 1){
					loc = "fr";
					lang = "rb_fr";
					locale = new Locale(loc);
			   		ResourceBundle resBun = ResourceBundle.getBundle(lang, locale);

					// set values for circle
					circlePanel.setDiameter(circleSlider.getValue());
					double area = (.25)*(3.14)*(circleSlider.getValue()*circleSlider.getValue());
					double circumference = (3.14)*(circleSlider.getValue());

					// set text
					textBox.setText(resBun.getString("Diameter") + ": " + circleSlider.getValue() +
						"\n" + resBun.getString("Area") + ": " + Math.round(area*100.0)/100.0 + "\n" +
							resBun.getString("Circumference") + ": " + Math.round(circumference*100.0)/100.0);
					}
			}
		}
	}

	// user input interpreted
	class Change implements ChangeListener
	{
		public void stateChanged(ChangeEvent col)
		{
			// calculations for diameter, area & circumference
			circlePanel.setDiameter(circleSlider.getValue());
			double area = (.25)*(3.14)*(circleSlider.getValue()*circleSlider.getValue());
			double circumference = (3.14)*(circleSlider.getValue());

			// create internationalisation standards
			locale = new Locale(loc);
		    ResourceBundle resBun = ResourceBundle.getBundle(lang, locale);

			// set text and figures for circle
			textBox.setText(resBun.getString("Diameter") + ": " + circleSlider.getValue() +
			"\n" + resBun.getString("Area") + ": " + Math.round(area*100.0)/100.0 + "\n" +
			resBun.getString("Circumference") + ": " + Math.round(circumference*100.0)/100.0);

			// get values for sliders to set colour of circle
			int r = redSlider.getValue();
			int g = greenSlider.getValue();
			int b = blueSlider.getValue();
			circlePanel.setForeground(new Color(r,g,b));
		}
	}







}