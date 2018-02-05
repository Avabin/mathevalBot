package tk.evkom.mathevalbot

class IndeterminateException(override val message: String = "Indeterminate system, infinite number of solutions."): Exception(message)