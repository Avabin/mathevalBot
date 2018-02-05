package tk.evkom.mathevalbot

class UnsolvableException(override val message: String = "Unsolvable system, there is no solution"): Exception(message)