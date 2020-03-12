package com.revature.data;

import com.revature.hibernate.beans.Status;
import com.revature.hibernate.beans.Task;

public interface StatusDAO {
		// create
		public Status addStatus(Status s);
		// read
		public Status getStatus(int i);
		public Status getStatusById(Status s);
		// update
		public void updateStatus(Status s);
		// delete
		public void deleteStatus(Status s);
}
