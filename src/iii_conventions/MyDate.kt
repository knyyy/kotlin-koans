package iii_conventions

import i_introduction._6_Data_Classes._06_Data_Classes

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    override fun compareTo(other: MyDate) =
            when {
                year != other.year -> year - other.year
                month != other.month -> month - other.month
                else -> dayOfMonth - other.dayOfMonth
            }

}

class RepeatedTimeInterval(val interval: TimeInterval, val num: Int)
operator fun MyDate.rangeTo(other: MyDate): DateRange = DateRange(this,other)
operator fun MyDate.plus(other: TimeInterval) = addTimeIntervals(other,1)
operator fun MyDate.plus(timeIntervals: RepeatedTimeInterval) = addTimeIntervals(timeIntervals.interval,timeIntervals.num )
operator fun TimeInterval.times(other: Int) = RepeatedTimeInterval(this, other)


enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

class DateRange(val start: MyDate, val endInclusive: MyDate) : Iterable<MyDate> {
    operator fun contains(d: MyDate) : Boolean { return d >= start && d <= endInclusive}
    override fun iterator(): Iterator<MyDate> = DataIteroator(this)
}

class DataIteroator(val dateRange: DateRange) : Iterator<MyDate> {
    var current = dateRange.start
    override fun hasNext(): Boolean {
        return current <= dateRange.endInclusive
    }

    override fun next(): MyDate {
        val result = current
        current = current.nextDay()
        return result
    }
}
