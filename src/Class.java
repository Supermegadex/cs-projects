public class Class {
  public String name;
  public String teacher;
  public String room;

  Class(String name, String teacher, String room) {
    this.name = name;
    this.teacher = teacher;
    this.room = room;
  }

  public String toRow(String num) {
    return String.format(Utils.boxFormat("v %s v %s v %s v %s v\n"), num, name, teacher, room);
  }
}