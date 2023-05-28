package Entities;

public abstract class GenericEntity {
    protected int id;

    public GenericEntity(){}
    public GenericEntity(int id)
    {
        this.id =id;
    }

    public int getId() {
        return id;
    }

    @Override
    public abstract String toString();
}
