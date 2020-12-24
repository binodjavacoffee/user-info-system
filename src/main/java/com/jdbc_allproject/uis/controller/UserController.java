package com.jdbc_allproject.uis.controller;

import java.util.List;

import javax.swing.JOptionPane;

import com.jdbc_allproject.uis.model.User;
import com.jdbc_allproject.uis.service.UserService;
import com.jdbc_allproject.uis.service.UserServiceImpl;

public class UserController {

	public static void main(String[] args) {
		UserService userService = new UserServiceImpl();
		String decision = "";

		do {
			String choice = JOptionPane.showInputDialog("Enter your choice save|update|delete|list|get:");

			switch (choice) {

			case "save":
				User user = getUser();
				int saved = userService.saveUserInfo(user);
				if (saved >= 1) {
					JOptionPane.showMessageDialog(null, "User info is saved successfully in db.");
				} else {
					JOptionPane.showMessageDialog(null, "Error in bd.");

				}
				break;

			case "update":
				User updatedUser = getUser();
				int id = Integer.parseInt(JOptionPane.showInputDialog("Enter ID"));
				updatedUser.setId(id);
				int updated = userService.updateUserInfo(updatedUser);
				if (updated >= 1) {
					JOptionPane.showMessageDialog(null, "User info is Updated successfully in db.");
				} else {
					JOptionPane.showMessageDialog(null, "Error in bd.");

				}
				break;

			case "delete":

				id = Integer.parseInt(JOptionPane.showInputDialog("Enter ID"));

				int deleted = userService.deleteUserInfo(id);
				if (deleted >= 1) {
					JOptionPane.showMessageDialog(null, "User info is deleted successfully in db.");
				} else {
					JOptionPane.showMessageDialog(null, "Error in bd.");

				}
				break;

			case "list":
				List<User> userList = userService.getAllUserInfo();
				for (User u : userList) {
					System.out.println("User id is : " + u.getId());
					System.out.println("User name is : " + u.getUsername());
					System.out.println("User password is : " + u.getPassword());
					System.out.println("User mobile_no is : " + u.getMobileNo());
					System.out.println("User Salary is : " + u.getSalary());
					System.out.println("is user active ? : " + u.isActive());
					System.out.println("=================================");
				}
				break;

			case "get":
				id = Integer.parseInt(JOptionPane.showInputDialog("Enter ID"));
				User u = userService.getUserById(id);

				System.out.println("User id is : " + u.getId());
				System.out.println("User name is : " + u.getUsername());
				System.out.println("User password is : " + u.getPassword());
				System.out.println("User mobile_no is : " + u.getMobileNo());
				System.out.println("User Salary is : " + u.getSalary());
				System.out.println("is user active ? : " + u.isActive());
				System.out.println("=================================");

				break;

			default:
				JOptionPane.showMessageDialog(null, "Wrong Choice.");
				break;
			}
			decision = JOptionPane.showInputDialog("Do you want to perform next function? Enter yes|no");
		} while (decision.equalsIgnoreCase("yes"));
		JOptionPane.showMessageDialog(null, "Bye bye jdbc .. see u again.");
	}

	public static User getUser() {

		User user = new User();
		String username = JOptionPane.showInputDialog("Enter username:");
		String password = JOptionPane.showInputDialog("Enter Password:");
		long mobileNo = Long.parseLong(JOptionPane.showInputDialog("Enter mobile No:"));
		double salary = Double.parseDouble(JOptionPane.showInputDialog("Enter salary"));
		boolean isActive = Boolean.parseBoolean(JOptionPane.showInputDialog("Enter is user active"));
		user.setUsername(username);
		user.setPassword(password);
		user.setMobileNo(mobileNo);
		user.setActive(isActive);
		user.setSalary(salary);
		return user;
	}
}
