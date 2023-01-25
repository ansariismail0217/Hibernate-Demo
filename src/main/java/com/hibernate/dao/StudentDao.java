package com.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.model.Student;
import com.hibernate.util.HibernateUtil;

public class StudentDao {

	// save student
	public void saveStudent(Student student) {

		Transaction transaction = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			// start transaction
			transaction = session.beginTransaction();

			// save student object
			session.save(student);

			// commit the transaction
			transaction.commit();

		} catch (Exception e) {

			if (transaction != null) {
				transaction.rollback();
			}

		}

	}

	public void updateStudent(Student student) {

		Transaction transaction = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			// start transaction
			transaction = session.beginTransaction();

			// save student object
			session.saveOrUpdate(student);

			// commit the transaction
			transaction.commit();

		} catch (Exception e) {

			if (transaction != null) {
				transaction.rollback();
			}

		}

	}

	public Student getStudentById(long id) {

		Transaction transaction = null;
		Student student = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			// start transaction
			transaction = session.beginTransaction();

			// get student object
			session.get(Student.class, id);

			// commit the transaction
			transaction.commit();

		} catch (Exception e) {

			if (transaction != null) {
				transaction.rollback();
			}

		}

		return student;

	}

	@SuppressWarnings("unchecked")
	public List<Student> getAllStudent() {

		Transaction transaction = null;
		List<Student> students = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			// start transaction
			transaction = session.beginTransaction();

			// get all students
			//hql query
			students = session.createQuery("from Student").list();

			// commit the transaction
			//transaction.commit();

		} catch (Exception e) {

			if (transaction != null) {
				transaction.rollback();
			}

		}

		return students;

	}
	
	public void deleteStudent(long id) {

		Transaction transaction = null;
		Student student = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			// start transaction
			transaction = session.beginTransaction();

			// get student object
			student = session.get(Student.class, id);
			session.delete(student);

			// commit the transaction
			transaction.commit();

		} catch (Exception e) {

			if (transaction != null) {
				transaction.rollback();
			}

		}

	}

}
