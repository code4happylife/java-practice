package study;

public class classroom {
	private String classRoomName;
    private static String teacherName;

    public void setClassRoomName(String newClassRoomName) {
        classRoomName = newClassRoomName;

    }

    public String returnClassRoomName() {
        return classRoomName;
    }

    public static void setTeacherName(String newTeacherName) {
        teacherName = newTeacherName;

    }

    public String returnTeacherName() {
        return teacherName;
    }
}
