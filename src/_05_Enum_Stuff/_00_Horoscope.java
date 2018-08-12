package _05_Enum_Stuff;

import java.util.Random;

import javax.swing.JOptionPane;

public class _00_Horoscope {
	// 1. Create an enum in a separate file called Zodiac that contains a category
	// for
	// all 12 zodiac signs.

	// 2. Write a method that takes in a Zodiac enum object and uses a JOPtionPane
	// to display
	// a different horoscope based on the Zodiac's state.

	// 3. Make a main method to test your method
	public static void main(String[] args) {

		Random random = new Random();

		zodiacDisplay(Zodiac.ARIES);
		zodiacDisplay(Zodiac.TAURUS);
		zodiacDisplay(Zodiac.GEMINI);
		zodiacDisplay(Zodiac.CANCER);
		zodiacDisplay(Zodiac.LEO);
		zodiacDisplay(Zodiac.VIRGO);
		zodiacDisplay(Zodiac.LIBRA);
		zodiacDisplay(Zodiac.SCORPIO);
		zodiacDisplay(Zodiac.SAGITTARIUS);
		zodiacDisplay(Zodiac.CAPRICORN);
		zodiacDisplay(Zodiac.AQUARIUS);
		zodiacDisplay(Zodiac.PISCES);

	}

	public static void zodiacDisplay(Zodiac z) {
		switch (z) {

		case ARIES:
			JOptionPane.showMessageDialog(null, "Aries - March 21, April 19");
			break;
		case TAURUS:
			JOptionPane.showMessageDialog(null, "Taurus - April 20, May 20");
			break;
		case GEMINI:
			JOptionPane.showMessageDialog(null, "Gemini - May 21, June 21");
			break;
		case CANCER:
			JOptionPane.showMessageDialog(null, "Cancer - June 21, July 22");
			break;
		case LEO:
			JOptionPane.showMessageDialog(null, "Leo - July 23, Aug 22");
			break;
		case VIRGO:
			JOptionPane.showMessageDialog(null, "Virgo - Aug 23, Sept 22");
			break;
		case LIBRA:
			JOptionPane.showMessageDialog(null, "Libra - Sept 23, October 23");
			break;
		case SCORPIO:
			JOptionPane.showMessageDialog(null, "Scorpio - October 24, November 22");
			break;
		case SAGITTARIUS:
			JOptionPane.showMessageDialog(null, "Sagittarius - November 23, December 21");
			break;
		case CAPRICORN:
			JOptionPane.showMessageDialog(null, "Capricon - December 22, January 20");
			break;
		case AQUARIUS:
			JOptionPane.showMessageDialog(null, "Aquarius - January 21, February 19");
			break;
		case PISCES:
			JOptionPane.showMessageDialog(null, "Pisces - February 20, March 20");
			break;
		}
	}
}
