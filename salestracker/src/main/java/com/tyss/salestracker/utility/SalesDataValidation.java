package com.tyss.salestracker.utility;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.tyss.salestracker.dto.ContactPersonInfoBean;
import com.tyss.salestracker.dto.SalesInfoBean;
import com.tyss.salestracker.exception.EmailAlreadyExistException;
import com.tyss.salestracker.exception.InvalidNameFormatException;
import com.tyss.salestracker.exception.InvalidNumberException;

public class SalesDataValidation {

	String email;
	String designation;
	List<Long> number;
	String personName;

	final Pattern validEmail = Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$");

	final Pattern validName = Pattern.compile("^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$");

	final Pattern validId = Pattern.compile("^[0-9]*$");

	public boolean registration(SalesInfoBean salesInfoBean) {

		Matcher clientNameMatcher = validName.matcher(salesInfoBean.getClientName().trim());
		Matcher locationMatcher = validName.matcher(salesInfoBean.getLocation().trim());
		Matcher domainMatcher = validName.matcher(salesInfoBean.getDomain().trim());
		Matcher statusMatcher = validName.matcher(salesInfoBean.getStatus().trim());

		if (salesInfoBean.getClientName() != "" && salesInfoBean.getDomain() != "" && salesInfoBean.getLocation() != ""
				&& salesInfoBean.getStatus() != "" && salesInfoBean.getRemarks() != "") {

			if ((clientNameMatcher.find() && salesInfoBean.getClientName().length() >= 1)
					&& (locationMatcher.find() && salesInfoBean.getLocation().length() >= 1)
					&& (domainMatcher.find() && salesInfoBean.getDomain().length() >= 1)
					&& (statusMatcher.find() && salesInfoBean.getStatus().length() >= 1)
					&& (salesInfoBean.getRemarks().length() >= 1)) {

				return true;

			} else {

				throw new InvalidNameFormatException("fields allowed only Alphabets");
			}
		} else {

			throw new InvalidNameFormatException("fields can't be blank");
		}
	}

	public boolean emailValidation(SalesInfoBean salesInfoBean) {

		for (ContactPersonInfoBean element : salesInfoBean.getCoPersonInfoBean()) {

			personName = element.getPersonName();
			designation = element.getDesignation();
			email = element.getEmail();
			number = element.getNumber();

		}

		Matcher emailMatcher = validEmail.matcher(email.trim());

		if (email != "") {

			if (emailMatcher.find() && email.length() >= 1) {

				return true;

			} else {
				throw new EmailAlreadyExistException("Email Allowes this format ex:abc@gmail.com");
			}
		} else {
			throw new EmailAlreadyExistException("Email Can't be blank");
		}
	}

	public boolean designation(SalesInfoBean bean) {

		for (ContactPersonInfoBean element : bean.getCoPersonInfoBean()) {

			designation = element.getDesignation();

		}

		Matcher designationMatcher = validName.matcher(designation.trim());

		if (designation != "") {

			if (designationMatcher.find() && designation.length() >= 2) {

				return true;
			} else {
				throw new InvalidNameFormatException("designation allowed only Alphabets");
			}
		} else {
			throw new InvalidNameFormatException("designation can't be blank");
		}
	}

	public boolean personName(SalesInfoBean bean) {

		for (ContactPersonInfoBean element : bean.getCoPersonInfoBean()) {

			personName = element.getPersonName();

		}

		Matcher personNameMatcher = validName.matcher(personName.trim());

		if (personName != "") {

			if (personNameMatcher.find() && personName.length() >= 2) {

				return true;
			} else {
				throw new InvalidNameFormatException("personName allowed only Alphabets");
			}
		} else {
			throw new InvalidNameFormatException("personName can't be blank");
		}
	}

	public boolean phoneNumber(SalesInfoBean bean) {
		int count = 0;
		int size = 0;
		for (ContactPersonInfoBean element : bean.getCoPersonInfoBean()) {

			for (Long long1 : element.getNumber()) {
				size = element.getNumber().size();
				number = Arrays.asList(long1);
				if(String.valueOf(long1) != "") {
					if (String.valueOf(long1).length() == 10) {
						count++;
					} else {
						throw new InvalidNumberException("Only 10 digids");
					}
				}else {
					throw new InvalidNumberException("Number can't be blank");
				}
				
			}
			if (count == size) {
				return true;
			}
		}

		Matcher phoneNumberMatcher = validId.matcher(personName.trim());

		if (personName != "") {

			if (phoneNumberMatcher.find() && personName.length() >= 2) {

				return true;
			} else {
				throw new InvalidNumberException("Phone Number allowed only Digits");
			}
		} else {
			throw new InvalidNumberException("Number can't be blank");
		}
	}

}
