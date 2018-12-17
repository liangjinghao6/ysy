package com.sifude.lejane.dao;

import org.springframework.stereotype.Repository;

@Repository("statActiveDao")
public interface IStatActiveDao {
	
	void delete();
	int checkStat();
	int moodStat();
	int feedbackStat();
	int callStat();
	int readStat();
	int checkproblemStat();
}
