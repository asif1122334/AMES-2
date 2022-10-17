package com.marlabs.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "associate_details_master")
public class AssociateDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String batchCode;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int associateId;
	private String associateName;
	private double assessorMark;
	private double mentorMark;
	private String assessorRemarks;
	private String mentorRemarks;

	public String getBatchCode() {
		return batchCode;
	}

	public void setBatchCode(String batchCode) {
		this.batchCode = batchCode;
	}

	public int getAssociateId() {
		return associateId;
	}

	public void setAssociateId(int associateId) {
		this.associateId = associateId;
	}

	public String getAssociateName() {
		return associateName;
	}

	public void setAssociateName(String associateName) {
		this.associateName = associateName;
	}

	public double getAssessorMark() {
		return assessorMark;
	}

	public void setAssessorMark(double assessorMark) {
		this.assessorMark = assessorMark;
	}

	public double getMentorMark() {
		return mentorMark;
	}

	public void setMentorMark(double mentorMark) {
		this.mentorMark = mentorMark;
	}

	public String getAssessorRemarks() {
		return assessorRemarks;
	}

	public void setAssessorRemarks(String assessorRemarks) {
		this.assessorRemarks = assessorRemarks;
	}

	public String getMentorRemarks() {
		return mentorRemarks;
	}

	public void setMentorRemark(String mentorRemarks) {
		this.mentorRemarks = mentorRemarks;
	}

	public AssociateDetails(String batchCode, int associateId, String associateName, double assessorMark,
			double mentorMark, String assessorRemarks, String mentorRemarks) {
		super();
		this.batchCode = batchCode;
		this.associateId = associateId;
		this.associateName = associateName;
		this.assessorMark = assessorMark;
		this.mentorMark = mentorMark;
		this.assessorRemarks = assessorRemarks;
		this.mentorRemarks = mentorRemarks;
	}

	public AssociateDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "AssociateDetails [batchCode=" + batchCode + ", associateId=" + associateId + ", associateName="
				+ associateName + ", assessorMark=" + assessorMark + ", mentorMark=" + mentorMark + ", assessorRemarks="
				+ assessorRemarks + ", mentorRemarks=" + mentorRemarks + "]";
	}

}
