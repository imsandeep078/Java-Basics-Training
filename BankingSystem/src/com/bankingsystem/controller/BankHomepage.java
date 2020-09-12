package com.bankingsystem.controller;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;

import com.bankingsystem.beans.FundTransfer;
import com.bankingsystem.beans.UserDetails;
import com.bankingsystem.dao.AccountHolder;
import com.bankingsystem.dao.Authentication;
import com.bankingsystem.dao.BankStatement;
import com.bankingsystem.dao.ChangePassword;
import com.bankingsystem.dao.CheckAdhaarNumber;
import com.bankingsystem.dao.ChequeBookApproval;
import com.bankingsystem.dao.ChequeBookRequest;
import com.bankingsystem.dao.FundTransferByUser;
import com.bankingsystem.dao.RegisteredUsersList;
import com.bankingsystem.dao.RemoveUserFromList;
import com.bankingsystem.dao.UserRegistration;
import com.bankingsystem.dao.ViewAccountDetails;
import com.bankingsystem.dao.ViewPersonalDetails;
import com.bankingsystem.repository.UsersRepository;

public class BankHomepage {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("\t-----------------");
		System.out.println("\t  BANK OF INDIA  ");
		System.out.println("\t-----------------");
		boolean flag = true;
		do {
			System.out.println("Press 1 - Sign In (If You Have Account)");
			System.out.println("Press 2 - Sign Up (for New Account Opening)");
			// System.out.println(UsersRepository.registeredAccountHolders().size());
			// Authentication.sample();
			System.out.print("Enter Your INPUT: ");
			flag = true;
			try {
				int userInput = scanner.nextInt();
				switch (userInput) {
				case 1:
					boolean check;
					do {
						System.out.print("Enter Your UserName: ");
						String userName = scanner.next();
						scanner.nextLine();
						System.out.print("Enter Your Password: ");
						String userPassword = scanner.nextLine();
						// String result = UserAuthentication.isValid(userName, userPassword);
						String result = Authentication.isValid(userName, userPassword);
						check = true;
						if (result.equals("user")) {
							boolean checkUserAfterLoginInput;
							do {
								// System.out.println(result);
								System.out.println("\tPress 1: View Profile");
								System.out.println("\tPress 2: View Account Details");
								System.out.println("\tPress 3: Funds Transfer");
								System.out.println("\tPress 4: View Mini Statement");
								System.out.println("\tPress 5: Request for Cheque Book");
								System.out.println("\tPress 6: Change/Update Password");
								System.out.println("\tPress 0: To Logout");
								System.out.print("Enter Your Input: ");
								checkUserAfterLoginInput = true;
								try {
									int userAfterLoginInput = scanner.nextInt();
									switch (userAfterLoginInput) {
									case 1:
										ViewPersonalDetails.viewPersonalDetails(userName, userPassword);
										do {
											System.out.print("Press 0 to Go Back: ");
											flag = true;
											try {
												int backFromDetails = scanner.nextInt();
												if (backFromDetails == 0) {
													checkUserAfterLoginInput = false;
												} else {
													System.out.println("\t---------------");
													System.out.println("\tInvalid input..");
													System.out.println("\t---------------");
													flag = false;
												}
											} catch (InputMismatchException e) {
												System.out.println("\t----------------------");
												System.out.println("\tOnly Numeric allowed..");
												System.out.println("\t----------------------");
											}
										} while (flag == false);
										break;

									case 2:
										ViewAccountDetails.viewAccountDetails(userName, userPassword);
										do {
											System.out.print("Press 0 to Go Back: ");
											flag = true;
											try {
												int backFromDetails = scanner.nextInt();
												if (backFromDetails == 0) {
													checkUserAfterLoginInput = false;
												} else {
													System.out.println("\t---------------");
													System.err.println("\tInvalid input..");
													System.out.println("\t---------------");
													flag = false;
												}
											} catch (InputMismatchException e) {
												System.out.println("\t----------------------");
												System.err.println("\tOnly Numeric allowed..");
												System.out.println("\t----------------------");
											}
										} while (flag == false);
										break;

									case 3:
										do {
											System.out.print("Enter Account Number to transfer: ");
											flag = true;
											try {
												long accountNum = scanner.nextLong();
												if (FundTransferByUser.isAccountNumPresent(accountNum)) {
													boolean isValidAmount;
													do {
														System.out.print("Enter Amount to be Transfered: ");
														isValidAmount = true;
														try {
															double transferAmount = scanner.nextDouble();
															double currentAmount = FundTransferByUser
																	.currentAmount(userName, userPassword);
															if (currentAmount != 0) {
																if (transferAmount > 0) {
																	if (transferAmount < currentAmount) {
																		FundTransfer fundTransfer = FundTransferByUser
																				.fundTransfer(userName, userPassword,
																						accountNum, transferAmount);
																		if (fundTransfer != null) {
																			System.out.println(
																					"\t------------------SuccessFully Transfered-----------------");
																			System.out.println(
																					"\tFrom Account\tTo Account\tAmount\t\tDate");
																			System.out.println("\t"
																					+ fundTransfer.getFromAccount()
																					+ "\t\t"
																					+ fundTransfer.getToAccount()
																					+ "\t\t" + fundTransfer.getAmount()
																					+ "\t\t"
																					+ fundTransfer.getTransferedDate());
																			System.out.println(
																					"\t----------------------------------------------------------");
																			checkUserAfterLoginInput = false;
																		} else {
																			System.err.println(
																					"\tCould not transfer...Something went wrong!!");
																		}
																	} else {
																		System.err.println(
																				"\tNot Enough Amount..to transfer");
																		isValidAmount = false;
																	}
																} else {
																	System.err.println("\tAmount must be greater than 0");
																	isValidAmount = false;
																}
															} else {
																System.err.println("\tYour Account balance is 0");
																checkUserAfterLoginInput = false;
															}
														} catch (InputMismatchException e) {
															System.out.println("\t----------------------");
															System.out.println("\tOnly Numeric allowed..");
															System.out.println("\t----------------------");
														}
													} while (isValidAmount == false);
												} else {
													System.err.println("\tThis Account does not exist..");
													flag = false;
												}
											} catch (InputMismatchException e) {
												System.out.println("\t----------------------");
												System.out.println("\tOnly Numeric allowed..");
												System.out.println("\t----------------------");
											}
										} while (flag == false);
										break;

									case 4:
										List<FundTransfer> miniStatement = BankStatement.miniStatement(userName,
												userPassword);
										if (miniStatement != null) {
											BankStatement.miniStatementList();
											do {
												System.out.print("Press 0 to Go Back: ");
												flag = true;
												try {
													int backInput = scanner.nextInt();
													if (backInput == 0) {
														checkUserAfterLoginInput = false;
													} else {
														System.out.println("\t---------------");
														System.out.println("\tInvalid input..");
														System.out.println("\t---------------");
														flag = false;
													}
												} catch (InputMismatchException e) {
													System.out.println("\t----------------------");
													System.out.println("\tOnly Numeric allowed..");
													System.out.println("\t----------------------");
												}
											} while (flag == false);
										} else {
											System.out.println("No Transactions done...");
											checkUserAfterLoginInput = false;
										}
										break;

									case 5:
										String message = ChequeBookRequest.requestChequeBook(userName, userPassword,
												"requested");
										System.out.println("\t----------------------------------------------");
										System.out.println("\t" + message);
										System.out.println("\t----------------------------------------------");
										checkUserAfterLoginInput = false;
										break;
										
									case 6:
										System.out.print("Set New Password: ");
										String newPassword = scanner.next();
										scanner.nextLine();
										if(ChangePassword.changedPassword(userName, userPassword, newPassword)) {
											System.out.println("\t-------------------------------");
											System.out.println("\tPassword Changed SuccessFully..");
											System.out.println("\t-------------------------------");
											flag = false;
										} else {
											System.out.println("\t-------------------------------");
											System.out.println("\tPassword Not Changed..Try Again");
											System.out.println("\t-------------------------------");
											checkUserAfterLoginInput = false;
										}
										break;
										
									case 0:
										flag = false;
										break;

									default:
										System.out.println("\t---------------");
										System.out.println("\tInvalid input..");
										System.out.println("\t---------------");
										checkUserAfterLoginInput = false;
										break;
									}
								} catch (InputMismatchException e) {
									System.out.println("\t----------------------");
									System.out.println("\tOnly Numeric allowed..");
									System.out.println("\t----------------------");
								}
							} while (checkUserAfterLoginInput == false);
						} else if (result.equals("admin")) {
							boolean isValidInput;
							do {
								System.out.println("\tPress 1: Registered Users");
								System.out.println("\tPress 2: List of Users Cheque Book Requests");
								System.out.println("\tPress 0: To Logout");
								System.out.print("Enter Your INPUT: ");
								isValidInput = true;
								try {
									int adminInput = scanner.nextInt();
									switch (adminInput) {
									case 1:
										Set<UserDetails> registeredUserDetails = UsersRepository.registeredUsersList();
										if (!registeredUserDetails.isEmpty()) {
											RegisteredUsersList.registeredUserList();
											try {
												boolean checkadminInput;
												do {
													System.out.println("Press 1 for CREATE Account for Users");
													System.out.println("Press 0 for BACK");
													System.out.print("Enter Your Input: ");
													int adminInputValue = scanner.nextInt();
													checkadminInput = true;
													switch (adminInputValue) {
													case 1:
														boolean checkAdhaar;
														do {
															System.out.print(
																	"Enter ADHAAR No. For Opening Account of a User : ");
															checkAdhaar = true;
															try {
																long adhaar = scanner.nextLong();
																if (CheckAdhaarNumber.isAdhaarExist(adhaar)) {
																	System.out
																			.println("\t----------------------------");
																	System.out
																			.println("\tFill Accout Details For User");
																	System.out
																			.println("\t----------------------------");
																	boolean checkAccountType;
																	do {
																		System.out.print(
																				"Enter Account Type [Savings/Current]: ");
																		String accountType = scanner.next();
																		scanner.nextLine();
																		checkAccountType = true;
																		if ((Pattern.matches("^[a-zA-Z]*$",
																				accountType) == true)
																				&& accountType != null) {
																			boolean checkAmount;
																			do {
																				System.out.print("Opening Amount: ");
																				double amount = scanner.nextDouble();
																				checkAmount = true;
																				try {
																					if (amount >= 1000) {
																						// long accnum =
																						// AccountOpening.accountOpening(accountType.toUpperCase(),
																						// amount);
																						// System.out.println(accnum);
																						System.out.println(
																								"\t------Create User Credentials------");
																						boolean checkUsernameInput;
																						String name;
																						do {
																							System.out.print(
																									"Create Username: ");
																							name = scanner.next();
																							scanner.nextLine();
																							checkUsernameInput = true;
																							if ((Pattern.matches(
																									"^[a-zA-Z]*$",
																									name) == true)
																									&& name != null) {
																								boolean checkPasswordInput;
																								String password;
																								do {
																									System.out.print(
																											"Create Password: ");
																									password = scanner
																											.nextLine();
																									checkPasswordInput = true;
																									if ((Pattern
																											.matches(
																													"^[a-zA-Z]*$",
																													password) == true)
																											&& password != null) {
																										String role;
																										boolean checkRoleInput;
																										do {
																											System.out
																													.print("Role[user/admin]: ");
																											role = scanner
																													.nextLine();
																											checkRoleInput = true;
																											if ((Pattern
																													.matches(
																															"^[a-zA-Z]*$",
																															role) == true)
																													&& role != null) {
																												boolean isAccountCreated = AccountHolder
																														.accountDetails(
																																accountType
																																		.toUpperCase(),
																																amount,
																																name,
																																password,
																																role.toLowerCase());
																												boolean isDetailsRegistered = AccountHolder
																														.userDetails(
																																adhaar,
																																name,
																																password,
																																role.toLowerCase());
																												if (isAccountCreated
																														&& isDetailsRegistered) {
																													boolean isRemoved = RemoveUserFromList
																															.removeUserFromList(
																																	adhaar);
																													if (isRemoved) {
																														System.out
																																.println(
																																		"\t--------------------------------");
																														System.out
																																.println(
																																		"\tAccount Created successFully..");
																														System.out
																																.println(
																																		"\t--------------------------------");

																														checkadminInput = false;
																													}

																												} else {
																													System.out
																															.println(
																																	"Account not created..Something went wrong");
																													isValidInput = false;
																												}
																											} else {
																												System.out
																														.println(
																																"\t----------------------");
																												System.out
																														.println(
																																"\tNumeric not allowed...");
																												System.out
																														.println(
																																"\t----------------------");
																												checkRoleInput = false;
																											}
																										} while (checkRoleInput == false);

																									} else {
																										System.out
																												.println(
																														"\t----------------------");
																										System.out
																												.println(
																														"\tNumeric not allowed...");
																										System.out
																												.println(
																														"\t----------------------");
																										checkPasswordInput = false;
																									}
																								} while (checkPasswordInput == false);

																							} else {
																								System.out.println(
																										"\t----------------------");
																								System.out.println(
																										"\tNumeric not allowed...");
																								System.out.println(
																										"\t----------------------");
																								checkUsernameInput = false;
																							}
																						} while (checkUsernameInput == false);

																					} else {
																						System.out.println(
																								"\t------------------------------");
																						System.out.println(
																								"\tAmount Must be 1000 or more...");
																						System.out.println(
																								"\t------------------------------");
																						checkAmount = false;
																					}
																				} catch (InputMismatchException e) {
																					System.out.println(
																							"\t----------------------");
																					System.out.println(
																							"\tOnly Numeric allowed..");
																					System.out.println(
																							"\t----------------------");
																				}
																			} while (checkAmount == false);
																		} else {
																			System.out.println(
																					"\t----------------------");
																			System.out.println(
																					"\tNumeric not allowed...");
																			System.out.println(
																					"\t----------------------");
																		}
																	} while (checkAccountType == false);

																} else {
																	System.out
																			.println("\t----------------------------");
																	System.out.println("\tThis adhaar is not exist..");
																	System.out
																			.println("\t----------------------------");
																	checkAdhaar = false;
																}
															} catch (InputMismatchException e) {
																System.out.println("\t----------------------");
																System.out.println("\tOnly Numeric allowed..");
																System.out.println("\t----------------------");
															}
														} while (checkAdhaar == false);
														break;

													case 0:
														isValidInput = false;
														break;

													default:
														System.out.println("\t---------------");
														System.out.println("\tInvalid input..");
														System.out.println("\t---------------");
														checkadminInput = false;
														break;
													}
												} while (checkadminInput == false);
											} catch (InputMismatchException e1) {
												System.out.println("\t----------------------");
												System.out.println("\tOnly Numeric allowed..");
												System.out.println("\t----------------------");
											}

										} else {
											System.out.println("\t--------------------------");
											System.out.println("\tNo Registered Applications");
											System.out.println("\t--------------------------");
											boolean checkLogout;
											do {
												System.out.println("Press 0 to logout: ");
												System.out.println("Press 1 to Back");
												System.out.print("Enter Your Input: ");
												int logoutOrBack = scanner.nextInt();
												checkLogout = true;
												try {
													switch (logoutOrBack) {
													case 0:
														flag = false;
														break;

													case 1:
														isValidInput = false;
														break;

													default:
														System.out.println("\t---------------");
														System.out.println("\tInvalid Input..");
														System.out.println("\t---------------");
														checkLogout = false;
														break;
													}

												} catch (InputMismatchException e) {
													System.out.println("\t----------------------");
													System.out.println("\tOnly Numeric allowed..");
													System.out.println("\t----------------------");
												}
											} while (checkLogout == false);
										}

										break;

									case 2:
										boolean message = ChequeBookApproval.chequeBookRequestList();
										if (message) {
											boolean accountInput;
											do {
												System.out.print("Enter Account Number to approved request: ");
												accountInput = true;
												try {
													long accountNumber = scanner.nextLong();
													if (ChequeBookApproval.isApproved(accountNumber)) {
														System.out.println("\t-----------------------");
														System.out.println("\tSuccessfully approved..");
														System.out.println("\t-----------------------");
														isValidInput = false;
													} else {
														System.out.println("\t------------------------------");
														System.out.println("\tThis account not in the list..");
														System.out.println("\t------------------------------");
														accountInput = true;
													}
												} catch (InputMismatchException e) {
													System.out.println("\t----------------------");
													System.out.println("\tOnly Numeric Allowed..");
													System.out.println("\t----------------------");
												}
											} while (accountInput == false);
										} else {
											System.out.println("\t-----------------");
											System.out.println("\tNo requests found");
											System.out.println("\t-----------------");
											isValidInput = false;
										}
										break;

									case 0:
										flag = false;
										break;

									default:
										isValidInput = false;
										System.out.println("\t---------------");
										System.out.println("\tInvalid Input..");
										System.out.println("\t---------------");
										break;
									}
								} catch (InputMismatchException e) {
									// throw new WrongInputExceptions("Only numeric value..");
									System.out.println("\t----------------------");
									System.out.println("\tOnly Numeric allowed..");
									System.out.println("\t----------------------");
								}
							} while (isValidInput == false);
						} else {
							System.out.println("\t-----------------------------------------------");
							System.out.println("\t"+result);
							System.out.println("\t-----------------------------------------------");
							check = false;
						}
					} while (check == false);
					break;

				case 2:
					System.out.println("\t-----------------------------");
					System.out.println("\tFill The Account Opening Form");
					System.out.println("\t-----------------------------");
					boolean checkFirstNamePattern;
					do {
						checkFirstNamePattern = true;
						System.out.print("First Name: ");
						String firstName = scanner.next();
						scanner.nextLine();
						if ((Pattern.matches("^[a-zA-Z]*$", firstName) == true) && firstName != null) {
							boolean checkLastNamePattern;
							do {
								checkLastNamePattern = true;
								System.out.print("Last Name: ");
								String lastName = scanner.nextLine();
								if ((Pattern.matches("^[a-zA-Z]*$", lastName) == true) && lastName != null) {
									boolean checkDatePattern;
									do {
										checkDatePattern = true;
										System.out.print("D.O.B: ");
										String dateOfBirth = scanner.nextLine();
//										if (Pattern.matches("^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$",
//												dateOfBirth)) {
										try {
											System.out.print("Phone No.: ");
											long phoneNumber = scanner.nextLong();
											System.out.print("ADHAAR No.: ");
											long adhaarNumber = scanner.nextLong();
											String message = UserRegistration.userRegistration(firstName, lastName,
													dateOfBirth, phoneNumber, adhaarNumber);
											if (message != null) {
												System.out.println("\t-----------------------");
												System.out.println("\t" + message);
												System.out.println("\t-----------------------");
												try {
													boolean checkInput;
													do {
														checkInput = true;
														System.out.print("Press 0 for exit: ");
														int value = scanner.nextInt();
														if (value == 0) {
															flag = false;
														} else {
															checkInput = false;
															System.err.println("Invalid!");
														}
													} while (checkInput == false);
												} catch (InputMismatchException e) {
													System.out.println("\t----------------------");
													System.out.println("\tOnly Numeric allowed..");
													System.out.println("\t----------------------");
												}
											}
										} catch (InputMismatchException e) {
											System.out.println("\t----------------------");
											System.out.println("\tOnly Numeric allowed..");
											System.out.println("\t----------------------");
										}
//										} else {
//											System.err.println("Pattern must be dd/mm/yyyy\ndd -> 01 to 31\nmm -> 01 to 12\nyyyy -> 4 digits");
//											checkDatePattern = false;
//										}
									} while (checkDatePattern == false);
								} else {
									System.out.println("\t----------------------");
									System.out.println("\tNumeric not allowed...");
									System.out.println("\t----------------------");
									checkLastNamePattern = false;
								}
							} while (checkLastNamePattern == false);
						} else {
							System.out.println("\t----------------------");
							System.out.println("\tNumeric not allowed...");
							System.out.println("\t----------------------");
							checkFirstNamePattern = false;
						}
					} while (checkFirstNamePattern == false);
					break;

				default:
					System.err.println("!INVALID try again");
					flag = false;
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("\t----------------------");
				System.out.println("\tOnly Numeric allowed..");
				System.out.println("\t----------------------");
			}
		} while (flag == false);
		scanner.close();
	}

}
