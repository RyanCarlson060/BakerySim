//Ryan Carlson
import javax.swing.JOptionPane;

public class BakerySimulation {

	public static void main(String[] args) {
		int money = 5000;
		int muffincost = 5, cookiecost = 3, cakecost = 30, breadcost = 8;
		int muffinmake = 2, cookiemake = 1, cakemake = 8, breadmake = 4;
		int muffs, cooks, cakes, breads;
		int muffinsold, cookiesold, cakesold, breadsold;
		int muffprof, cookprof, cakeprof, breadprof;
		String response;
		int counter = 0;
		int randomoccurence = 0;
		System.out.println("Make as much money as possible without spending more than you have. You have $" + money + ".");
		System.out.println(
				"A muffin normally costs $2 to make and sells for $5. You can sell up to 600 at a time.");
		System.out.println(
				"A cookie normally costs $1 to make and sells for $3. You can sell up to 1550 at a time.");
		System.out.println(
				"A cake normally costs $8 to make and sells for $30. You can sell up to 410 at a time.");
		System.out.println(
				"A loaf of bread normally costs $4 to make and sells for $8. You can sell up to 3000 at a time.");

		do {

			int season = (int) (Math.random() * 51);
			if (season == randomoccurence) {
				muffincost = muffincost + 10;
				cookiecost = cookiecost + 10;
				cakecost = cakecost + 10;
				breadcost = breadcost + 10;
				System.out.println("It's wedding season everything sells for 10 dollars more!");
			}
			do {
				response = JOptionPane.showInputDialog("How many muffins will you make?");
				muffs = Integer.parseInt(response);
				response = JOptionPane.showInputDialog("How many cookies will you make?");
				cooks = Integer.parseInt(response);
				response = JOptionPane.showInputDialog("How many cakes will you make?");
				cakes = Integer.parseInt(response);
				response = JOptionPane.showInputDialog("How many loaves of bread will you make?");
				breads = Integer.parseInt(response);
			} while (muffs < 0 || cooks < 0 || cakes < 0 || breads < 0);

			int pricechange = (int) (Math.random() * 101);
			if (pricechange == randomoccurence) {
				response = JOptionPane.showInputDialog(
						"Type 1 to increase quality by having cake cost $5 more to make and sell for $8 more?");
				int increase = Integer.parseInt(response);
				if (increase == 1) {
					cakecost = cakecost + 8;
					cakemake = cakemake + 5;
				}
			}

			int muffloss = (muffs * muffinmake);
			int cookloss = (cooks * cookiemake);
			int cakeloss = (cakes * cakemake);
			int breadloss = (breads * breadmake);

			if (muffloss + cookloss + cakeloss + breadloss > money) {
				System.out.println("You went over the spending limit. You are in debt 5000 dollars.");
				money = -5000;
			}

			muffinsold = (int) (Math.random() * 501) + 100;
			cookiesold = (int) (Math.random() *1501) + 50;
			cakesold = (int) (Math.random() * 401) + 10;
			breadsold = (int) (Math.random() * 3001);
			
			if (muffs < muffinsold) {
				muffprof = (muffs * muffincost) - muffloss;
			} else {
				muffprof = (muffinsold * muffincost) - muffloss;
			}

			if (cooks < cookiesold) {
				cookprof = (cooks * cookiecost) - cookloss;
			} else {
				cookprof = (cookiesold * cookiecost) - cookloss;
			}
			if (cakes < cakesold) {
				cakeprof = (cakes * cakecost) - cakeloss;
			} else {
				cakeprof = (cakesold * cakecost) - cakeloss;
			}
			if (breads < breadsold) {
				breadprof = (breads * breadcost) - breadloss;
			} else {
				breadprof = (breadsold * breadcost) - breadloss;
			}

			counter++;
			int tax = (int) (Math.random() * 51);
			if (tax == randomoccurence) {
				money = money - 10000;
				System.out.println("It's tax day you lost 10000 dollars. Now you only have " + money);
			}

			int encounter = (int) (Math.random() * 1000000001);
			if (encounter == randomoccurence) {
				System.out.println("A man dropped 1000000000 dollars in your tip jar. Congrats");
				money = money + 1000000000;
			}
			int rent = (int) (Math.random() * 8);
			if (rent == randomoccurence) {
				money = money - 100000;
				System.out.println("You need to pay rent. You lose 100000 dollars.");
			}

			money = breadprof + cakeprof + muffprof + cookprof + money;
			if (money < 0) {
				System.out.println("You are bankrupt.");
			} else {
				System.out.println("After another month, you have " + money + " dollars.");
			}
		} while (money > 0);
		System.out.println("You stayed in buisness " + counter + " months.");
		if (counter < 36) {
			System.out.println("I guess you're just another failed buisness.");
		} else {
			System.out.println("You are a genius.");
		}
	}

}
