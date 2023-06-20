INSERT INTO residues(residue_type,description)VALUES('EXTRAORDINÁRIO','CLASS IIA');
INSERT INTO residues(residue_type,description)VALUES('ENTULHO','CLASS IIB');
INSERT INTO equipments(equipment,size_cubic)VALUES('CONTAINER 1.2M³','1.2');
INSERT INTO equipments(equipment,size_cubic)VALUES('CONTAINER 240L','0.24');
INSERT INTO application_users(username,password)VALUES('madruga','mama');
INSERT INTO application_users(username,password)VALUES('chaves','cha');
INSERT INTO roles(role_name)VALUES('ADMIN');
INSERT INTO roles(role_name)VALUES('CUSTOMER');
INSERT INTO roles(role_name)VALUES('MANAGER');
INSERT INTO users_roles(application_user_id,role_id)VALUES(1,1);
INSERT INTO users_roles(application_user_id,role_id)VALUES(1,3);
INSERT INTO users_roles(application_user_id,role_id)VALUES(2,2);

