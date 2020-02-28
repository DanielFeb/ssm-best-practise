package indi.daniel.archessm.domain.auth.model;

import com.google.common.base.Preconditions;
import indi.daniel.archessm.common.ApplicationConstants;
import indi.daniel.archessm.domain.shared.Entity;
import indi.daniel.archessm.domain.shared.TraceInformation;
import org.apache.commons.lang3.StringUtils;
import org.apache.tomcat.util.security.MD5Encoder;
import org.joda.time.DateTime;

import java.util.Collections;
import java.util.Set;

public class User implements Entity<User, UserId> {

    private static final String DEFAULT_ADDRESS = "I'm from Mars!";
    private static final Sex DEFAULT_SEX = Sex.SECRET;
    private static final DateTime DEFAULT_BIRTHDAY = ApplicationConstants.DEFAULT_DATETIME;
    private static final TraceInformation DEFAULT_TRACE_INFORMATION = TraceInformation.EMPTY_TRACE_INFORMATION;


    private UserId id;

    private String username;
    private String password;
//    private String email;
//    private String phoneNumber;
//    private String identityNumber;
    private String nickname;
    private Sex sex;
    private String address;
    private DateTime birthDay;
    private TraceInformation traceInformation;

    private Set<RoleId> roleIds;


    User(UserId id, String username, String password) {
        this(
                id,
                username,
                password,
                username,
                DEFAULT_SEX,
                DEFAULT_ADDRESS,
                DEFAULT_BIRTHDAY,
                DEFAULT_TRACE_INFORMATION,
                Collections.EMPTY_SET);
    }

    public User(UserId id,
                String username,
                String password,
                String nickname,
                Sex sex,
                String address,
                DateTime birthDay,
                TraceInformation traceInformation,
                Set<RoleId> roleIds) {
        this.setId(id);
        this.setUsername(username);
        this.setPassword(password);
        this.setNickname(nickname);
        this.setSex(sex);
        this.setAddress(address);
        this.setBirthDay(birthDay);
        this.setTraceInformation(traceInformation);
        this.setRoleIds(roleIds);
    }

    private void setRoleIds(Set<RoleId> roleIds) {
        Preconditions.checkArgument(null != roleIds);
        this.roleIds = roleIds;
    }

    private void setId(UserId userId) {
        Preconditions.checkArgument(null != userId);
        this.id = userId;
    }


    private void setTraceInformation(TraceInformation traceInformation) {
        Preconditions.checkArgument(null != traceInformation);
        this.traceInformation = traceInformation;
    }


    public void setNickname(String nickname) {
        Preconditions.checkArgument(StringUtils.isNotEmpty(nickname));
        this.nickname = nickname;
    }

    public void setUsername(String username) {
        Preconditions.checkArgument(StringUtils.isNotEmpty(username));
        this.username = username;
    }

    public void setSex(Sex sex) {
        Preconditions.checkArgument(null != sex);
        this.sex = sex;
    }

    public void setAddress(String address) {
        Preconditions.checkArgument(StringUtils.isNotEmpty(address));
        this.address = address;
    }

    public void setBirthDay(DateTime birthDay) {
        Preconditions.checkArgument(null != birthDay);
        this.birthDay = birthDay;
    }

    public void setAge(int age) {
        this.setBirthDay(getDefaultBirthDay(age));
    }

    public void setPassword(String password) {
        Preconditions.checkArgument(StringUtils.isNotEmpty(password));
        this.password = password;
    }

    public boolean checkPassword(String password) {
        Preconditions.checkArgument(StringUtils.isNotEmpty(password));
        return this.password().equals(MD5Encoder.encode(password.getBytes()));
    }

    private static boolean isValidAge(int age) {
        return age > 0;
    }

    private static DateTime getDefaultBirthDay(int age) {
        Preconditions.checkArgument(isValidAge(age));
        return DateTime.now().minusYears(age);
    }

    @Override
    public UserId id() {
        return id;
    }

    public String nickname() {
        return nickname;
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

    public int age() {
        return DateTime.now().getYear() - birthDay.getYear();
    }

    public String password() {
        return password;
    }

    public String username() {
        return username;
    }

    public Set<RoleId> roleIds() {
        return Collections.unmodifiableSet(roleIds);
    }

    public void addRole(Role role) {
        this.roleIds.add(role.id());
    }

    public void removeRole(Role role) {
        this.roleIds.remove(role.id());
    }

    public boolean hasRole(Role role) {
        return this.roleIds.contains(role.id());
    }

    @Override
    public void verify() {
        // 保存之前要验证的东西
        if (nickname == null) {

        }
    }
}
