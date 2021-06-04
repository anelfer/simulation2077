package me.anelfer.simulation.map;

import lombok.Data;

import java.util.Objects;

@Data
public class MapLocation {

    private final int X;
    private final int Y;

    public MapLocation(int X, int Y) {
        this.X = X;
        this.Y = Y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MapLocation that = (MapLocation) o;
        return Y == that.Y && X == that.X;
    }

    @Override
    public int hashCode() {
        return Objects.hash(X, Y);
    }

}
