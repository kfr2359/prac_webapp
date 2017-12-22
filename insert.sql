use prac_db;

-- service_type
insert into service_type (name) values	("Создание документов"),
										("Восстановление документов"),
										("Сопровождение документов"),
										("Банкротсво"),
										("Эмиссия акций"),
										("Сопрвождение сделок"),
										("Судебное представительство"),
										("Консультация");
									   
insert into `client` (name) values	("Иванов Иван Иванович"),
									("Менкеев Андрей Сергеевич"),
									("ООО Союз Детективов Руси");
                         
insert into job (name) values	("Юрист-стажер"),
								("Менеджер"),
								("Юрист-консультант");

insert into employee (name, address, education, jobId) values	("Петров Андрей Алексеевич", "Москва Лебедянская 8-50", "МГУ Юрфак", 1),
																("Сидоров Владимир Станиславович", "Москва Лебедянская 4-53", "МГУ Юрфак", 2),
																("Петренко Иван Андреевич", "Москва Шеногина 4к3", "МГУ Юрфак", 3);
insert into employee_phone (employeeId, phone) values	(1, "9676512312"),
														(2, "9673247659"),
														(2, "9169879343"),
														(3, "9153243565");
insert into employee_email (employeeId, email) values	(1, "a.petrov@mail.ru"),
														(2, "v.sydorov@mail.ru"),
														(3, "y.petrenko@mail.ru");
                                 
insert into client_contact (name, address, clientId) values	("Иванов Иван Иванович", "Москва Саратовская 12-43", 1),
															("Менкеев Андрей Сергеевич", "Москва Люблинская 17-110", 2),
															("Мартынов Андрей Владимирович", "Москва Тверская 17-4", 3);
insert into client_contact_phone (contactId, phone) values	(1, "9092543321"),
															(2, "9677654765"),
															(3, "9157135458");
insert into client_contact_email (contactId, email) values	(1, "y.yvanov@mail.ru"),
															(2, "a.menkeev@mail.ru"),
															(3, "a.martynov@mail.ru");
                                       
insert into service (typeId, clientId, cost, startDate, endDate) values (1, 1, 5000, "2010.10.12", "2010.10.14"),
                                                                        (2, 2, 2000, "2010.10.15", "2010.10.17"),
                                                                        (3, 3, 7000, "2010.10.18", "2010.10.20"),
                                                                        (3, 3, 8000, "2010.10.21", "2010.10.23");

insert into service_employee (serviceId, employeeId) values (1, 1),
                                                            (2, 2),
                                                            (3, 3);
