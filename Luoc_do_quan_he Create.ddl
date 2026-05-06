-- database tên: QLTTNN
USE QLTTNN
GO
CREATE TABLE tblBill (
  id            int IDENTITY NOT NULL, 
  createdAt     datetime NOT NULL, 
  payedAmount   float(10) NOT NULL, 
  paymentType   nvarchar(255) NOT NULL,
  userId        int NOT NULL,
  registeringId int NOT NULL, 
  PRIMARY KEY (id));
CREATE TABLE tblBranch (
  id         int IDENTITY NOT NULL, 
  branchName nvarchar(255) NOT NULL,
  address    nvarchar(255) NOT NULL,
  PRIMARY KEY (id));
CREATE TABLE tblClassRoom (
  id       int IDENTITY NOT NULL, 
  capacity int NOT NULL, 
  roomName nvarchar(255) NOT NULL,
  branchId int NOT NULL, 
  PRIMARY KEY (id));
CREATE TABLE tblCourseClass (
  id        int IDENTITY NOT NULL, 
  className nvarchar(255) NOT NULL,
  startDate date NOT NULL, 
  levelId   int NOT NULL, 
  branchId  int NOT NULL, 
  PRIMARY KEY (id));
CREATE TABLE tblLevel (
  id            int IDENTITY NOT NULL, 
  levelName     nvarchar(255) NOT NULL,
  entryLevel    float(10) NOT NULL, 
  targetLevel   float(10) NOT NULL, 
  payRate       float(10) NOT NULL, 
  totalSessions int NOT NULL, 
  tuition       float(10) NOT NULL, 
  programId     int NOT NULL, 
  PRIMARY KEY (id));
CREATE TABLE tblProgram (
  id          int IDENTITY NOT NULL, 
  programName nvarchar(255) NOT NULL,
  description nvarchar(255) NOT NULL,
  PRIMARY KEY (id));
CREATE TABLE tblRegisteredClass (
  id            int IDENTITY NOT NULL, 
  tuition       float(10) NOT NULL, 
  saleOff       float(10) NOT NULL, 
  registeringId int NOT NULL, 
  courseClassId int NOT NULL, 
  PRIMARY KEY (id));
CREATE TABLE tblRegisteredSession (
  id                     int IDENTITY NOT NULL, 
  status                 nvarchar(255) NOT NULL,
  teachingRegistrationId int NOT NULL, 
  sessionId              int NOT NULL, 
  PRIMARY KEY (id));
CREATE TABLE tblRegistering (
  id              int IDENTITY NOT NULL, 
  registeringDate date NOT NULL, 
  saleOff         float(10) NOT NULL, 
  userId          int NOT NULL, 
  studentId       int NOT NULL, 
  PRIMARY KEY (id));
CREATE TABLE tblSession (
  id            int IDENTITY NOT NULL, 
  skill         nvarchar(255) NOT NULL,
  [date]        date NOT NULL, 
  classRoomId   int NOT NULL, 
  shiftId       int NOT NULL, 
  courseClassid int NOT NULL, 
  PRIMARY KEY (id));
CREATE TABLE tblShift (
  id        int IDENTITY NOT NULL, 
  shiftName nvarchar(255) NOT NULL,
  startTime time(7) NOT NULL, 
  endTime   time(7) NOT NULL, 
  PRIMARY KEY (id));
CREATE TABLE tblStudent (
  id          int IDENTITY NOT NULL, 
  fullName    nvarchar(255) NOT NULL,
  idCard      nvarchar(255) NOT NULL UNIQUE,
  phone       nvarchar(255) NOT NULL,
  dateOfBirth date NOT NULL, 
  email       nvarchar(255) NOT NULL,
  address     nvarchar(255) NOT NULL,
  PRIMARY KEY (id));
CREATE TABLE tblTeacher (
  userId int NOT NULL, 
  PRIMARY KEY (userId));
CREATE TABLE tblTeachingRegistration (
  id            int IDENTITY NOT NULL, 
  totalSessions int NOT NULL, 
  teacherId      int NOT NULL,
  PRIMARY KEY (id));
CREATE TABLE tblUser (
  id          int IDENTITY NOT NULL, 
  username    nvarchar(255) NOT NULL,
  password    nvarchar(255) NOT NULL,
  fullName    nvarchar(255) NOT NULL,
  dateOfBirth date NOT NULL, 
  phone       nvarchar(255) NOT NULL,
  address     nvarchar(255) NOT NULL,
  role        nvarchar(255) NOT NULL,
  PRIMARY KEY (id));
ALTER TABLE tblBill ADD CONSTRAINT FK_Bill_User FOREIGN KEY (userId) REFERENCES tblUser (id);
ALTER TABLE tblRegistering ADD CONSTRAINT F_Registering_User FOREIGN KEY (userId) REFERENCES tblUser (id);
ALTER TABLE tblBill ADD CONSTRAINT FK_Bill_Registering FOREIGN KEY (registeringId) REFERENCES tblRegistering (id);
ALTER TABLE tblRegistering ADD CONSTRAINT FK_Registering_Student FOREIGN KEY (studentId) REFERENCES tblStudent (id);
ALTER TABLE tblCourseClass ADD CONSTRAINT FK_CourseClass_Level FOREIGN KEY (levelId) REFERENCES tblLevel (id);
ALTER TABLE tblLevel ADD CONSTRAINT FK_Level_Program FOREIGN KEY (programId) REFERENCES tblProgram (id);
ALTER TABLE tblClassRoom ADD CONSTRAINT FK_ClassRoom_Branch FOREIGN KEY (branchId) REFERENCES tblBranch (id);
ALTER TABLE tblSession ADD CONSTRAINT FK_Session_ClassRoom FOREIGN KEY (classRoomId) REFERENCES tblClassRoom (id);
ALTER TABLE tblSession ADD CONSTRAINT FK_Session_Shift FOREIGN KEY (shiftId) REFERENCES tblShift (id);
ALTER TABLE tblRegisteredClass ADD CONSTRAINT FK_RegisteredClass_Registering FOREIGN KEY (registeringId) REFERENCES tblRegistering (id);
ALTER TABLE tblRegisteredClass ADD CONSTRAINT FK_RegisteredClass_CourseClass FOREIGN KEY (courseClassId) REFERENCES tblCourseClass (id);
ALTER TABLE tblSession ADD CONSTRAINT FK_Session_CourseClass FOREIGN KEY (courseClassid) REFERENCES tblCourseClass (id);
ALTER TABLE tblTeachingRegistration ADD CONSTRAINT FK_TeachingRegistration_Teacher FOREIGN KEY (teacherId) REFERENCES tblTeacher (userId);
ALTER TABLE tblTeacher ADD CONSTRAINT FK_Teacher_User FOREIGN KEY (userId) REFERENCES tblUser (id);
ALTER TABLE tblRegisteredSession ADD CONSTRAINT FK_RegisteredSession_TeachingRegistration FOREIGN KEY (teachingRegistrationId) REFERENCES tblTeachingRegistration (id);
ALTER TABLE tblRegisteredSession ADD CONSTRAINT FK_RegisteredSession_Session FOREIGN KEY (sessionId) REFERENCES tblSession (id);
ALTER TABLE tblCourseClass ADD CONSTRAINT FK_CourseClass_Branch FOREIGN KEY (branchId) REFERENCES tblBranch (id);

insert into dbo.tblUser (username, password, fullName, dateOfBirth, phone, address, role)
values
('a', 'a@123', N'Nguyễn Văn A', '1990-01-01', '0912345678', N'Hà Nội', 'enrollemt staff');
