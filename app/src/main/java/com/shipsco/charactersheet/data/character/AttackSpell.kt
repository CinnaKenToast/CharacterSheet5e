package com.shipsco.charactersheet.data.character

import kotlinx.serialization.Serializable

@Serializable
data class AttackSpell(
    var name: String = "",
    var attackBonus: String = "",
    var damageType: String = ""
)

val blankAttackSpell = MutableList(20) { AttackSpell(name = "", attackBonus = "", damageType = "") }

val testAttackSpells = mutableListOf(
    AttackSpell("Rapier","+3","Sever"),
    AttackSpell("Rapier","+3","Sever"),
    AttackSpell("Rapier","+3","Sever"),
    AttackSpell("Rapier","+3","Sever"),
    AttackSpell("Rapier","+3","Sever"),
    AttackSpell("Rapier","+3","Sever"),
    AttackSpell("Rapier","+3","Sever"),
    AttackSpell("Rapier","+3","Sever"),
    AttackSpell("Rapier","+3","Sever"),
    AttackSpell("Rapier","+3","Sever"),
    AttackSpell("Rapier","+3","Sever"),
    AttackSpell("Rapier","+3","Sever"),
    AttackSpell("Rapier","+3","Sever"),
    AttackSpell("Rapier","+3","Sever"),
    AttackSpell("Rapier","+3","Sever"),
    AttackSpell("Rapier","+3","Sever"),
    AttackSpell("Rapier","+3","Sever"),
    AttackSpell("Rapier","+3","Sever"),
    AttackSpell("Rapier","+3","Sever"),
    AttackSpell("Rapier","+3","Sever")
)