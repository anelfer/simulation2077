package me.anelfer.simulation.map;

import lombok.Data;

import java.util.Objects;

@Data
public class MapLocation {
    private final int row;
    private final int column;

    public MapLocation(int row, int column) {
        this.row = row;
        this.column = column;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MapLocation that = (MapLocation) o;
        return row == that.row && column == that.column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }

}
