package indi.daniel.archessm.domain.shared;

public interface JsonSerializable<T> {
    String toJson();
    T fromJson(String json);
}
