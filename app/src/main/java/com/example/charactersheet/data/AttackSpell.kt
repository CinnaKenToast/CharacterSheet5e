package com.example.charactersheet.data

import kotlinx.serialization.Serializable

@Serializable
data class AttackSpell(
    var name: String = "",
    var attackBonus: String = "",
    var damageType: String = ""
)

val blankAttackSpell = mutableListOf(
    AttackSpell(name = "", attackBonus = "", damageType = ""),
    AttackSpell(name = "", attackBonus = "", damageType = ""),
    AttackSpell(name = "", attackBonus = "", damageType = ""),
    AttackSpell(name = "", attackBonus = "", damageType = ""),
    AttackSpell(name = "", attackBonus = "", damageType = ""),
    AttackSpell(name = "", attackBonus = "", damageType = ""),
    AttackSpell(name = "", attackBonus = "", damageType = ""),
    AttackSpell(name = "", attackBonus = "", damageType = ""),
    AttackSpell(name = "", attackBonus = "", damageType = ""),
    AttackSpell(name = "", attackBonus = "", damageType = ""),
    AttackSpell(name = "", attackBonus = "", damageType = ""),
    AttackSpell(name = "", attackBonus = "", damageType = ""),
    AttackSpell(name = "", attackBonus = "", damageType = ""),
    AttackSpell(name = "", attackBonus = "", damageType = ""),
    AttackSpell(name = "", attackBonus = "", damageType = ""),
    AttackSpell(name = "", attackBonus = "", damageType = ""),
    AttackSpell(name = "", attackBonus = "", damageType = ""),
    AttackSpell(name = "", attackBonus = "", damageType = ""),
    AttackSpell(name = "", attackBonus = "", damageType = ""),
    AttackSpell(name = "", attackBonus = "", damageType = "")
)

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