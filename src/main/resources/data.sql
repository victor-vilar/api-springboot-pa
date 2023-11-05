INSERT INTO residues(type,description)VALUES('EXTRAORDINÁRIO','CLASSE IIA');
INSERT INTO residues(type,description)VALUES('ENTULHO','CLASSE IIB');
INSERT INTO equipments(equipment,size_cubic)VALUES('CONTAINER 1.2M³','1.2');
INSERT INTO equipments(equipment,size_cubic)VALUES('CONTAINER 240L','0.24');
INSERT INTO application_users(username,password,profile_photo_url)VALUES('madruga','mama','/assets/madruga-profile.jpg');
INSERT INTO application_users(username,password,profile_photo_url)VALUES('chaves','cha','/assets/chaves-profile.jpg');
INSERT INTO roles(role_name)VALUES('ADMIN');
INSERT INTO roles(role_name)VALUES('CUSTOMER');
INSERT INTO roles(role_name)VALUES('MANAGER');
INSERT INTO users_roles(application_user_id,role_id)VALUES(1,1);
INSERT INTO users_roles(application_user_id,role_id)VALUES(1,3);
INSERT INTO users_roles(application_user_id,role_id)VALUES(2,2);
INSERT INTO clients(cpf_cnpj,name_company_name,is_active)VALUES('08454836000178','EMPRESA 1',true);
INSERT INTO clients(cpf_cnpj,name_company_name,is_active)VALUES('29439167000135','INSTITUTO MILITAR DE ESCOTEIROS DE APARTAMENTO',true);
INSERT INTO clients(cpf_cnpj,name_company_name,is_active)VALUES('43715989000122','COMANDO DOS PODERES FRACOS DE OPERAÇÕES ESPECIALIZADAS EM ABSTRAÇÕES BASTANTE ESPECIFICAS',true);

INSERT INTO supervisors(name,role,phone_number,email,customer_id)VALUES('ALFREDINHO ROBERTINHO','GERENTINHO','21999999999','gerentinho@gmail.com','08454836000178');
INSERT INTO supervisors(name,role,phone_number,email,customer_id)VALUES('AFRANIO NOVAES MENDONÇA CARDOSO VASCONCELOS','ESCOTEIRO','21999999999','escoteiro@gmail.com','29439167000135');

