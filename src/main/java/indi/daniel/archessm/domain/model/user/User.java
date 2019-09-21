package indi.daniel.archessm.domain.model.user;

import indi.daniel.archessm.domain.shared.Entity;
import indi.daniel.archessm.domain.shared.TraceInformation;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;

public class User implements Entity<User, UserId> {
    public User(UserId id, String name, Sex sex, String address, int age) {
        this(id, name, sex, address, getDefaultBirthDay(age));
    }

    private static boolean isValidAge(int age) {
        return age > 0;
    }

    private static DateTime getDefaultBirthDay(int age) {
        assert isValidAge(age);
        return DateTime.now().minusYears(age);
    }

    public User(UserId id, String name, Sex sex, String address, DateTime birthDay) {
        this(id, name, sex, address, birthDay, TraceInformation.EMPTY_TRACE_INFORMATION);
    }

    public User(UserId id, String name, Sex sex, String address, DateTime birthDay, TraceInformation traceInformation) {
        this.id = id;
        setName(name);
        setSex(sex);
        setAddress(address);
        setBirthDay(birthDay);
        this.traceInformation = traceInformation;
    }

    public void setName(String name) {
        assert StringUtils.isNotEmpty(name);
        this.name = name;
    }

    public void setSex(Sex sex) {
        assert sex != null;
        this.sex = sex;
    }

    public void setAddress(String address) {
        assert StringUtils.isNotEmpty(address);
        this.address = address;
    }

    public void setBirthDay(DateTime birthDay) {
        assert birthDay != null;
        this.birthDay = birthDay;
    }

    @Override
    public UserId id() {
        return id;
    }

    public String name() {
        return name;
    }

    public Sex sex() {
        return sex;
    }

    public String address() {
        return address;
    }

    public DateTime birthDay() {
        return birthDay;
    }

    public TraceInformation traceInformation() {
        return traceInformation;
    }

    private UserId id;
    private String name;
    private Sex sex;
    private String address;
    private DateTime birthDay;
    private TraceInformation traceInformation;

    public void changeName(String newName) {
        this.name = newName;
    }

    public int age() {
        return DateTime.now().getYear() - birthDay.getYear();
    }
}
