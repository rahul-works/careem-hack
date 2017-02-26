package com.app.dao;

import com.app.entity.db1.Captain;
import com.app.entity.db1.CaptainUpdate;

public interface CaptianDao {

	Captain addCaptian(Captain addCaptianRQ);

	Captain updateCaptian(Captain addCaptianRQ);

	Captain getCaptian(int captianId);

	CaptainUpdate updateCaptianStatus(CaptainUpdate captianUpdate);}
