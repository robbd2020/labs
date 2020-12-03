package org.domain;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "Winkelwagen.vindAlle", query = "select w from Winkelwagen w")
public class Winkelwagen extends AbstracteEntiteit {}
